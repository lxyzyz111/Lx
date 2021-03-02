package com.example.lxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class PopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        val mBtnPopupWindow = findViewById<Button>(R.id.btn_popUpWindow)
        var mPop: PopupWindow
        var view: View = LayoutInflater.from(this).inflate(R.layout.popup_window,null)
        var textView = findViewById<TextView>(R.id.tv_good)
        mBtnPopupWindow.setOnClickListener{
            mPop = PopupWindow(view,mBtnPopupWindow.width,ViewGroup.LayoutParams.WRAP_CONTENT)
            mPop.isOutsideTouchable = true//
            mPop.isFocusable = true
            mPop.showAsDropDown(mBtnPopupWindow)
            Log.d("PopupActivity","mBtnPopupWindow.setOnClickListener")
//            textView.setOnClickListener {
//                mPop.dismiss()
////                Toast.makeText(this, "好好", LENGTH_SHORT).show()
//                Log.d("PopupActivity","textView.setOnClickListener")
//            }
        }
    }

    fun onClickTV(view: View) {
        Toast.makeText(this, "好好", LENGTH_SHORT).show()
        Log.d("onClickTV","点击事件")
    }

}