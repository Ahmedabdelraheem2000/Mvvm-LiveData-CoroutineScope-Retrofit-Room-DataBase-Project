package com.shopping.livedata.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shopping.livedata.R
import com.shopping.livedata.db.DataBasePosts
import com.shopping.livedata.model.PostsItem
import com.shopping.livedata.repostory.Repostory_Posts
import com.shopping.livedata.viewmodel.ViewModelPosts

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModelPosts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initilaze_Mvvm()


       }
    public fun initilaze_Mvvm(){
        var database= DataBasePosts.createDatabase(this)
        var repostory= Repostory_Posts(database.getDao())
        viewModel=ViewModelPosts(repostory)
        viewModel.getAllRecord().observe(this,{
            initilaze_Recycler(it)
        })
    }
    public fun initilaze_Recycler(posts: List<PostsItem>){
        var mainAdapter=MainAdapter(posts)
        var recycler=findViewById<RecyclerView>(R.id.recycler)
        recycler.apply {

            adapter=mainAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
            mainAdapter.notifyDataSetChanged()
        }
    }
}