package com.example.lxy

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        val mTv = findViewById<TextView>(R.id.text1)
        val mTv2 = findViewById<TextView>(R.id.text2)
        val mTv3 = findViewById<TextView>(R.id.text3)
        //添加删除线
        mTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        //添加下划线
        mTv2.paint.flags = Paint.UNDERLINE_TEXT_FLAG
        mTv3.isSelected = true
    }
}