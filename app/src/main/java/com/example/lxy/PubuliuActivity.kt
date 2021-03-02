package com.example.lxy

import android.content.res.Resources
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class PubuliuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pubuliu)
        val pubuliuVIEW = findViewById<RecyclerView>(R.id.pubuliu_view)
        pubuliuVIEW.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
        pubuliuVIEW.addItemDecoration(MyDecoration())
        pubuliuVIEW.adapter = StaggeredGridAdapter(this,object : StaggeredGridAdapter.OnItemClickListener {
            override fun onClick(pos: Int) {
                Toast.makeText(this@PubuliuActivity, "点击了..$pos", Toast.LENGTH_SHORT).show()

            }
        })
    }
    class MyDecoration : RecyclerView.ItemDecoration(){
        override fun getItemOffsets(outRect: Rect,view: View,parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.set(2,2,2,2)
        }
    }
}