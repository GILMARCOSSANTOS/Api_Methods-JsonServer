package com.example.apimethods_jsonserver.post_method.controller

import com.example.apimethods_jsonserver.post_method.model.PostModelRequest
import com.example.apimethods_jsonserver.post_method.model.PostModelResponse
import com.example.apimethods_jsonserver.post_method.service.PostService
import com.example.apimethods_jsonserver.service_main.ApiConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostController {

    private val apiService: PostService

    init {
        val apiConnection = ApiConnection()
        apiService = apiConnection.createService(PostService::class.java)
    }

    fun postData(data: PostModelRequest, callback: (Response<PostModelResponse>?, Throwable?) -> Unit) {
        val call = apiService.postData(data)

        call.enqueue(object : Callback<PostModelResponse> {

            override fun onResponse(call: Call<PostModelResponse>, response: Response<PostModelResponse>) {

                if (response.isSuccessful) {

                    callback(response, null)

                } else {

                    callback(null, Exception("Request failed with status: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<PostModelResponse>, t: Throwable) {

                callback(null, t)
            }
        })
    }
}

