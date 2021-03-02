package com.example.lxy

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ToastActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        val mBtnToast1 = findViewById<Button>(R.id.btn_toast_1)
        val mBtnToast2 = findViewById<Button>(R.id.btn_toast_2)
        val mBtnToast3 = findViewById<Button>(R.id.btn_toast_3)
        mBtnToast1.setOnClickListener(this)
        mBtnToast2.setOnClickListener(this)
        mBtnToast3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_toast_1 -> {
                Toast.makeText(applicationContext, "Toast1", Toast.LENGTH_LONG).show()
                println("btn_toast_1")
            }
            R.id.btn_toast_2 -> {
                var toastCenter: Toast = Toast.makeText( applicationContext,"居中Toast",  Toast.LENGTH_LONG  )
//                toastCenter.setGravity(Gravity.CENTER, 0, 0)//不起作用
                toastCenter.show()
                println("btn_toast_2")
            }
            R.id.btn_toast_3 -> {   //自定义toast废弃了
                var toastCustom: Toast = Toast(applicationContext)
                var layoutInflater: LayoutInflater = LayoutInflater.from(applicationContext)
                var view: View = layoutInflater.inflate(R.layout.layout_toast,null)
                val textView = view.findViewById<TextView>(R.id.tv_toast)
                val imageView = view.findViewById<ImageView>(R.id.iv_toast)
                textView.text = "自定义Toast"
                toastCustom.view = view
                toastCustom.show()

            }
        }
    }
}