package com.example.recyclerviewstaggeredlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewstaggeredlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setRecyclerView()
    }

    private fun setRecyclerView(){
        val list = ArrayList<RecyclerViewItem>()
        var count = 0

        for (i in 1..10){
            if (count == 0){
                val obj = RecyclerViewItem(R.drawable.image_one)
                list.add(obj)
                count = 1
            }else{
                val obj = RecyclerViewItem(R.drawable.image_two)
                list.add(obj)
                count = 0;
            }
        }

        val adapter = Adapter(this,list)
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        adapter.notifyDataSetChanged()
    }
}