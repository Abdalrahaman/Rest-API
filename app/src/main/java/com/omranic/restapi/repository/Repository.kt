package com.omranic.restapi.repository

import com.omranic.restapi.model.Post
import com.omranic.restapi.network.AppApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Repository @Inject constructor(private val appApiService: AppApiService) {

    fun getPosts(): Single<List<Post>> {
        return appApiService.getPost(userId = "1")
    }
}