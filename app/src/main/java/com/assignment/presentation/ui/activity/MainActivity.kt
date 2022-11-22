package com.assignment.presentation.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.databinding.MainActivityBinding
import com.assignment.presentation.base.BaseActivity
import com.assignment.presentation.model.User
import com.assignment.presentation.ui.adapter.UserAdapter
import com.assignment.presentation.utilities.Utils.Companion.isInternetConnected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {
    private val viewModel: MainActivityViewModel by viewModels()

    private var listItems: List<User>? = null

    override fun subscribeToObservers() {
        viewModel.apply {
            listData.observe(this@MainActivity) {
                listItems = it.data
                setupAdapter()
            }
            userFromDatbase.observe(this@MainActivity) {
                listItems = it.map { item ->
                    User(
                        item.id,
                        item.name,
                        item.email,
                        item.gender,
                        item.status
                    )
                }
                setupAdapter()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isInternetConnected()) {
            viewModel.getListData()
        } else {
              viewModel.getAllUsers()
        }
    }

    private fun setupAdapter() {
        binding.rvlist.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvlist.adapter =
            listItems?.let { UserAdapter(it) }
    }

    override fun getViewBinding(): MainActivityBinding = MainActivityBinding.inflate(layoutInflater)

}