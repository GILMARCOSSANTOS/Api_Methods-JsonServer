package com.example.apimethods_jsonserver.get_method.service

import com.example.apimethods_jsonserver.get_method.model.ModelGetItem

interface GetResponse {

    fun successResponseGet(successGet: List<ModelGetItem>)

    fun errorResponseGet(errorGet: String)
}