package com.omranic.restapi.network

import com.omranic.restapi.model.Post
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppApiService {

    @GET("posts")
    fun getPost(@Query("userId") userId: String): Single<List<Post>>

    @POST("posts")
    fun createPost(@Body post: Post): Observable<Post>
}