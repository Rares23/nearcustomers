package com.intercom.nearcustomers.ui.activities

import android.app.Activity
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.intercom.nearcustomers.NearCustomersApp
import com.intercom.nearcustomers.R
import com.intercom.nearcustomers.ui.adapters.UsersListAdapter
import com.intercom.nearcustomers.view_models.UsersListViewModel
import kotlinx.android.synthetic.main.content_users_list.*
import kotlinx.android.synthetic.main.seek_bar_view_range.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var usersListViewModel: UsersListViewModel

    private lateinit var usersListAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)

        initUi()
        initViewModel()
    }

    private fun initUi() {
        initToolbar()
        initUsersList()
        initSeekBar()
    }

    private fun initSeekBar() {
        seekBar_range.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                usersListViewModel.loadUsers(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }

    private fun initUsersList() {
        usersListAdapter = UsersListAdapter(this)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView_usersList.adapter = usersListAdapter
        recyclerView_usersList.layoutManager = layoutManager
    }

    private fun initViewModel() {
        (application as NearCustomersApp).getAppComponent().inject(this)
        usersListViewModel.range.observe(this, Observer {
            textView_range.text = getString(R.string.range, it.toString())
        })

        usersListViewModel.usersList.observe(this, Observer {
            usersListAdapter.setUsers(it)

            textView_userCount.text = getString(R.string.customers_count, it.size.toString())
        })

        usersListViewModel.loadUsers()
    }
}