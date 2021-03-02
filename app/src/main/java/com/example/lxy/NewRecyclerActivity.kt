package com.example.lxy

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class NewRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recycler)
        val newRecyclerView = findViewById<RecyclerView>(R.id.new_recyclerview)
        newRecyclerView.addItemDecoration(MyDecoration())
        newRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        newRecyclerView.adapter = NewRecyclerAdapter(this,object : NewRecyclerAdapter.OnItemClickListener {
            override fun onClick(pos: Int) {
                Toast.makeText(this@NewRecyclerActivity, "点击了..$pos", Toast.LENGTH_SHORT).show()

            }
        })
    }
    class MyDecoration : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.set(0,0,0,5)
        }
    }
}