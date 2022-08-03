package com.shopping.livedata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shopping.livedata.model.PostsItem

@Database(entities = [PostsItem::class] , version = 1)
abstract class DataBasePosts : RoomDatabase() {
    abstract fun getDao() : DaoPosts

    companion object{
        @Volatile
        private var INSTANCE:DataBasePosts?=null
        fun createDatabase(context: Context):DataBasePosts{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBasePosts::class.java,
                    "breakingbaddb.dp"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}