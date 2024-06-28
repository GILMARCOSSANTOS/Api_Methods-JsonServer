package com.example.apimethods_jsonserver.get_method.service

import com.example.apimethods_jsonserver.get_method.model.ModelGetItem
import retrofit2.http.GET

interface GetService {

    @GET("personalData")
    fun getService(): retrofit2.Call<List<ModelGetItem>>
}