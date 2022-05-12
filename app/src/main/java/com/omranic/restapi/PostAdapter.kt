package com.omranic.restapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omranic.restapi.databinding.PostItemBinding

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private lateinit var _postItemBinding: PostItemBinding
    private var posts = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        _postItemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(_postItemBinding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPost(newPosts: MutableList<Post>){
        posts = newPosts
        notifyDataSetChanged()
    }

    inner class PostViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(index: Int){
            binding.tvTitle.text = posts[index].title
            binding.tvBody.text = posts[index].body
        }
    }

}