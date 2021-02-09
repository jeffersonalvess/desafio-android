package com.picpay.desafio.android.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.adapters.UserListAdapter
import com.picpay.desafio.android.viewmodel.ContactsViewModel
import com.picpay.desafio.android.viewmodel.DataLoadingState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsActivity : AppCompatActivity() {

    private val viewModel by viewModel<ContactsViewModel>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val adapter by lazy { UserListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.data.observe(this, Observer {
            adapter.users = it
        })

        viewModel.loadingState.observe(this, Observer {
            when (it.status) {
                DataLoadingState.Status.FAILED -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE

                    Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                }

                DataLoadingState.Status.RUNNING -> {
                    progressBar.visibility = View.VISIBLE
                }

                DataLoadingState.Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
            }
        })

    }
}
