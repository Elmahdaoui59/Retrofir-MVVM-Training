package com.example.retrofitmvvmtraining.data

import com.example.retrofitmvvmtraining.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}