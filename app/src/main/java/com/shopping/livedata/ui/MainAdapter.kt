package com.shopping.livedata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.livedata.databinding.ItemBinding
import com.shopping.livedata.model.Posts
import com.shopping.livedata.model.PostsItem

class MainAdapter(var posts: List<PostsItem>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    class MainHolder(var binding : ItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding.apply {
            var postitem=posts.get(position)
            title.text=postitem.title
            body.text=postitem.body
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}