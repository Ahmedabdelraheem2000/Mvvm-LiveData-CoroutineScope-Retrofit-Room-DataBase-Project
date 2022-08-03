package com.shopping.livedata.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostsItem")
data class PostsItem(
    @PrimaryKey
    val id: Int,
    val body: String,
    val title: String
){}