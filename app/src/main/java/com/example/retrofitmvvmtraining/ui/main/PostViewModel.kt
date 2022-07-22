package com.example.retrofitmvvmtraining.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmtraining.data.PostsClient
import com.example.retrofitmvvmtraining.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel: ViewModel() {

    private val _posts = MutableLiveData<List<PostModel>>()
    val posts: LiveData<List<PostModel>> = _posts

    fun getPosts() {
        PostsClient.getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                _posts.value = response.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.i("aly", t.message.toString())

            }
        })
    }
}