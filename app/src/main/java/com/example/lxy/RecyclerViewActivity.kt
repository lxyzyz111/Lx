package com.example.lxy

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val img = findViewById<ImageView>(R.id.imageView)
        val context : Context

        val mImgIds = arrayOf<Int>(
                R.drawable.img_07951, R.drawable.ic_launcher_background,
                R.drawable.img_07951, R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background, R.drawable.img_07951,
                R.drawable.ic_launcher_foreground, R.drawable.img_07951
        )
        var liste_received: ArrayList<Int> = ArrayList()
        for (i in 0 until mImgIds.size) {
                liste_received.add(mImgIds[i])
            }
        liste_received.add(mImgIds[0])//多加了一个图片，以使能全部显示所有图片
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//        recyclerView.layoutManager = GridLayoutManager(this,3)//GridLayoutManager(this,RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = RecyclerAdapter(this, liste_received, object : RecyclerAdapter.OnItemClickListener {
            override fun onClick(pos: Int) {
                Toast.makeText(this@RecyclerViewActivity, "点击了..$pos", Toast.LENGTH_SHORT).show()
                img.setImageResource(liste_received[pos])
            }
        })

        img.setImageResource(liste_received[0])
        recyclerView.scrollToPosition(0)
        var  lastItem: Int =0;
        val scrollRunnable: Runnable = object : Runnable {
            override fun run() {
                recyclerView.scrollBy(3, 0);
                var layoutManager = recyclerView.layoutManager as LinearLayoutManager
//                var layoutManager = recyclerView.layoutManager as GridLayoutManager
                lastItem = layoutManager.findLastVisibleItemPosition()
                if (lastItem >= mImgIds.size && lastItem > 0) {
                    println(lastItem)
                    recyclerView.scrollToPosition(0)
                    lastItem = 0
                }
                recyclerView.postDelayed(this, 10)//时间ms,10ms走3个像素，控制图片滚动速度
            }
        }

        recyclerView.post(scrollRunnable)
    }
}
