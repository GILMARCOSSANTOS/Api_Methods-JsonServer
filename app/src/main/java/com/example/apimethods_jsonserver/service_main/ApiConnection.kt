package com.example.apimethods_jsonserver.service_main

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    class ApiConnection() {

        lateinit var retrofit: Retrofit
        val httpClient = OkHttpClient.Builder()
        val enviroment = ApiInitialConfig()

        private fun getHeaderInterceptor(): Interceptor {

            return Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                // .addHeader(key, token)
                chain.proceed(request)
            }
        }

        fun getRetrofitInstance(): Retrofit {

            if (!::retrofit.isInitialized) {

                httpClient.addInterceptor(getHeaderInterceptor())
                httpClient.networkInterceptors()
                retrofit = Retrofit.Builder()
                    .baseUrl(enviroment.getEnviroment().urlBase)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <S> createService(serviceClass: Class<S>): S {

            return getRetrofitInstance().create(serviceClass)
        }
    }
