package com.example.retrofitmvvmtraining.data

import com.example.retrofitmvvmtraining.model.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//to use it just call >>>> ""PostClient.postInterface"

object PostsClient{
    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private fun postClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val postInterface: PostInterface by lazy {
        postClient().create(PostInterface::class.java)
    }
    fun getPosts(): Call<List<PostModel>> {
        return postInterface.getPosts()
    }

}