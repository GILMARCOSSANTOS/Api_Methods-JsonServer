package com.example.apimethods_jsonserver.post_method.service

import com.example.apimethods_jsonserver.post_method.model.PostModelRequest
import com.example.apimethods_jsonserver.post_method.model.PostModelResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostService  {

    @POST("personalData")
    fun postData(@Body data: PostModelRequest): Call<PostModelResponse>
}