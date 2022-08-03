package com.shopping.livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shopping.livedata.model.Posts
import com.shopping.livedata.model.PostsItem
import com.shopping.livedata.repostory.Repostory_Posts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelPosts(var repostoryPosts: Repostory_Posts) : ViewModel() {
    init {
        CallApi()
    }
     public fun getAllRecord() : LiveData<List<PostsItem>>{
         return repostoryPosts.getDataFromDataBase()
     }
    private fun CallApi(){
        CoroutineScope(Dispatchers.IO).launch {
            repostoryPosts.CallApi()
        }

    }

}