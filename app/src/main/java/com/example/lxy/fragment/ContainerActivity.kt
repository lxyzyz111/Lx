package com.example.lxy.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lxy.R

class ContainerActivity : AppCompatActivity() , AFragment.IOnMessageClick {
    lateinit private var mTextView: TextView //这里不能用find，否则报错
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        var aFragment: AFragment = AFragment().newInstance("我是参数")
        var bFragment: BFragment = BFragment()
        mTextView = findViewById<TextView>(R.id.tv_show)
        val mBtnChange = findViewById<Button>(R.id.btn_change_2)
        mBtnChange.setOnClickListener {
        supportFragmentManager.beginTransaction().replace(R.id.fl_container,bFragment,"b").addToBackStack(null).commitAllowingStateLoss()
        }

        var fragment: Fragment? = supportFragmentManager.findFragmentByTag("a")
        if (fragment != null){
            supportFragmentManager.beginTransaction().add(R.id.fl_container, aFragment,"a").addToBackStack(null).commitAllowingStateLoss()
        }
    }

//    fun setDdata(title: String){//采用函数fragment把数据传递给Activity
//        mTextView.text = title
//    }

    override fun onClick(text: String) {
        super.onClick(text)
        mTextView.text = text
    }

}