package com.example.apimethods_jsonserver.get_method.model

import com.google.gson.annotations.SerializedName

data class ModelGetItem(

    @SerializedName("age")
    val age: Int,

    @SerializedName("id")
    val id: String,

    @SerializedName("identification")
    val identification: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("phone")
    val phone: Long
)