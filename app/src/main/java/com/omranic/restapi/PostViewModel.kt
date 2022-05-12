package com.omranic.restapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class PostViewModel: ViewModel() {
    private var posts = MutableLiveData<List<Post>>()

    fun getPosts(): LiveData<List<Post>> {
        loadPosts()
        return posts
    }

    private fun loadPosts() {
        ClientAPI.getINSTANCE().getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Post>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(t: List<Post>) {
                    posts.value = t
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}