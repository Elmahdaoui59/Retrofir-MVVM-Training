package com.example.retrofitmvvmtraining.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmtraining.databinding.PostItemBinding
import com.example.retrofitmvvmtraining.model.PostModel

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {


    private var postsList = ArrayList<PostModel>()

    class PostViewHolder(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = postsList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        with(holder) {
            with(postsList[position]) {
                binding.titleTV.text = this.title
                binding.userIdTV.text = this.userId.toString()
                binding.bodyTV.text = this.body
            }
        }
    }

    fun setPostsList(listOfPosts: ArrayList<PostModel>) {
        postsList = listOfPosts
        Log.i("aly", "${postsList.size}")
        notifyDataSetChanged()
    }

}