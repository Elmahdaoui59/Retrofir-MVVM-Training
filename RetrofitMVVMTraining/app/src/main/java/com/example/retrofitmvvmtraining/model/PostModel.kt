package com.example.retrofitmvvmtraining.model

import retrofit2.http.Body

class PostModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
}