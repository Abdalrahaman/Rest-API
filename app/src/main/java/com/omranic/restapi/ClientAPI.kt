package com.omranic.restapi

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI {
    companion object {
        private val  BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var INSTANCE: ClientAPI? = null
        fun getINSTANCE(): ClientAPI{
            if (INSTANCE == null){
                INSTANCE = ClientAPI()
            }
            return INSTANCE as ClientAPI
        }
    }

    private var apiInterface: ApiInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getPosts(): Single<List<Post>> {
        return apiInterface.getPost(userId = "1")
    }
}