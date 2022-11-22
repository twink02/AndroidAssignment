package com.assignment.presentation.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.domain.usecase.UserUseCase
import com.assignment.presentation.model.UserListResponse
import com.assignment.di.db.UsersDao
import com.assignment.di.entity.UsersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val dao: UsersDao) : ViewModel() {
    private val userUserCase by lazy { UserUseCase() }
    val listData = MutableLiveData<UserListResponse>()
    val onError = MutableLiveData<Boolean>()
    val userFromDatbase = MutableLiveData<List<UsersEntity>>()
    fun getListData() {
        userUserCase.fetchData(::onApiSuccess, ::onApiFailure)
    }

    private fun onApiSuccess(temp: UserListResponse) {
        listData.value = temp
        CoroutineScope(Dispatchers.IO).launch {
            temp.data.let { users ->
                for (i in users.indices) {
                    //data loaded to the entity
                    val usersEntity = UsersEntity(
                        users[i].id,
                        users[i].name,
                        users[i].email,
                        users[i].gender,
                        users[i].status
                    )
                    //using dao to insert data to the database
                    dao.insertUser(usersEntity)
                }
            }
        }
    }

    private fun onApiFailure(exception: Exception) {
        onError.value = true
    }

    fun getAllUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            val list = dao.getAllUsers()
            userFromDatbase.postValue(list)
        }
    }
}