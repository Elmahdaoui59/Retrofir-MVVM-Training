package com.example.retrofitmvvmtraining.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmtraining.R
import com.example.retrofitmvvmtraining.databinding.ActivityMainBinding
import com.example.retrofitmvvmtraining.databinding.PostItemBinding
import com.example.retrofitmvvmtraining.model.PostModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: PostItemBinding

    private val postViewModel: PostViewModel by lazy {
        ViewModelProvider(this)[PostViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val postsAdapter = PostsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postsAdapter

        postViewModel.getPosts()

        postViewModel.posts.observe(this){
            postsAdapter.setPostsList(it as ArrayList<PostModel>)
        }
    }
}