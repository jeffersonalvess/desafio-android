package com.picpay.desafio.android.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.picpay.desafio.android.R
import com.picpay.desafio.android.adapter.UserListAdapter
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.viewmodel.ContactsViewModel
import com.picpay.desafio.android.viewmodel.DataLoadingState.Status.FAILED
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsActivity : AppCompatActivity() {

    private val viewModel by viewModel<ContactsViewModel>()

    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { UserListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupRecycler()
        observeDataFetchFail()
        setContentView(binding.root)
    }

    private fun setupRecycler() {
        binding.recyclerView.adapter = adapter

        viewModel.data.observe(this, {
            adapter.users = it
        })
    }

    private fun observeDataFetchFail() {
        viewModel.loadingState.observe(this, {
            if (it.status == FAILED) {
                Toast.makeText(baseContext, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }
        })
    }
}
