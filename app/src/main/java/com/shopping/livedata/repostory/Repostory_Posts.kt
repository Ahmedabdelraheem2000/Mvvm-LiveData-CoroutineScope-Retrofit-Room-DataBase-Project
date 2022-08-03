package com.shopping.livedata.repostory

import androidx.lifecycle.LiveData
import com.shopping.livedata.db.DaoPosts
import com.shopping.livedata.model.Posts
import com.shopping.livedata.model.PostsItem
import com.shopping.livedata.server.Posts_Instence
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repostory_Posts(private var dataBaseDao: DaoPosts) {
   suspend fun CallApi(){
           Posts_Instence.api.getPostFrom_API().enqueue(object : Callback<Posts>{
               override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                   if(response.isSuccessful){
                            CoroutineScope(Dispatchers.IO).launch {
                                dataBaseDao.DeleteAllItem()
                                InsertDataIntoDataBase(response.body()!!)
                            }

                   }
               }

               override fun onFailure(call: Call<Posts>, t: Throwable) {

               }
           })


    }
    private suspend fun InsertDataIntoDataBase(posts: Posts)= dataBaseDao.InsertItemIntoDataBase(posts)

    fun getDataFromDataBase() : LiveData<List<PostsItem>>{
      return dataBaseDao.getDataFromDataBase()
   }


}