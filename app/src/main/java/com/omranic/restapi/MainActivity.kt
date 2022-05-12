package com.omranic.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.omranic.restapi.databinding.ActivityMainBinding
import retrofit2.*

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var apiInterface: ApiInterface
    val adapter = PostAdapter()

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PostViewModel::class.java]

        binding.recyclerView.adapter = adapter

        viewModel.getPosts().observe(this, Observer {
            adapter.setPost(it.toMutableList())
        })

    }
}