package com.shopping.livedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shopping.livedata.model.Posts
import com.shopping.livedata.model.PostsItem

@Dao
interface DaoPosts {
    //Get Data From DataBase OfLine LiveData<Posts>
    @Query("SELECT * FROM PostsItem")
      fun getDataFromDataBase():LiveData<List<PostsItem>>

    //Insert Data Into DataBase Ofline ArrayList<PostItem>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun InsertItemIntoDataBase(posts: Posts)

    //Delete All Item in DataBase
    @Query("Delete From PostsItem")
      fun DeleteAllItem()
}