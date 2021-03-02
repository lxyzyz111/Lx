package com.example.lxy

import android.content.DialogInterface.OnMultiChoiceClickListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class DialogActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        val mBtnDialog1 = findViewById<Button>(R.id.btn_dialog1)
        val mBtnDialog2 = findViewById<Button>(R.id.btn_dialog2)
        val mBtnDialog3 = findViewById<Button>(R.id.btn_dialog3)
        val mBtnDialog4 = findViewById<Button>(R.id.btn_dialog4)
        val mBtnDialog5 = findViewById<Button>(R.id.btn_dialog5)
        mBtnDialog1.setOnClickListener(this)
        mBtnDialog2.setOnClickListener(this)
        mBtnDialog3.setOnClickListener(this)
        mBtnDialog4.setOnClickListener(this)
        mBtnDialog5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_dialog1 -> run {
                var builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("请回答").setMessage("你觉得课程怎么样？")
                    .setIcon(R.drawable.ic_launcher_foreground)
                builder.setPositiveButton("OK") { dialog, which ->
                    Toast.makeText(this@DialogActivity, "你很诚实", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("不行") { dialog, which ->
                    Toast.makeText(this@DialogActivity, "睁眼说瞎话", Toast.LENGTH_SHORT).show()
                }
                builder.setNeutralButton("还行") { dialog, which ->
                    Toast.makeText(this@DialogActivity, "你再瞅瞅", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
            R.id.btn_dialog2 -> {
                val array = arrayOf("男", "女")
                var builder1: AlertDialog.Builder = AlertDialog.Builder(this)
                builder1.setTitle("选择性别").setItems(array) { dialog, which ->
                    Toast.makeText(this@DialogActivity, array[which], Toast.LENGTH_SHORT).show()
                }
                builder1.setCancelable(true).show()
            }
            R.id.btn_dialog3 -> {
                val array2 = arrayOf("男", "女")
                var builder2: AlertDialog.Builder = AlertDialog.Builder(this)
                builder2.setTitle("选择性别").setSingleChoiceItems(array2, 1) { dialog, which ->
                    Toast.makeText(this@DialogActivity, array2[which], Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                builder2.setCancelable(false).show()
            }
            R.id.btn_dialog4 -> {
                val array3 = arrayOf("唱歌", "跳舞", "写代码")
                var isSelected = booleanArrayOf(true, false, true)//[true,false,true]
                var builder3: AlertDialog.Builder = AlertDialog.Builder(this)
                builder3.setTitle("选择性别").setMultiChoiceItems(array3, isSelected) { dialog, which, isChecked ->
                    Toast.makeText(this@DialogActivity, array3[which] + "：" + isSelected[which], Toast.LENGTH_SHORT).show()
                }
                builder3.setPositiveButton("确定") { dialog, which ->
                    Toast.makeText(this@DialogActivity, "确定", Toast.LENGTH_SHORT).show()
                }
                builder3.setNegativeButton("取消") { dialog, which ->
                    Toast.makeText(this@DialogActivity, "退出", Toast.LENGTH_SHORT).show()
                }
                builder3.show()
            }
            R.id.btn_dialog5 -> {
                var builder4: AlertDialog.Builder = AlertDialog.Builder(this)
                var view: View = LayoutInflater.from(this@DialogActivity).inflate(R.layout.layout_dialog5,null)
                val userName = findViewById<EditText>(R.id.Name)
                val password = findViewById<EditText>(R.id.Password)
                val btnLogin = findViewById<Button>(R.id.login)
//                btnLogin.setOnClickListener{
//                        Toast.makeText(this, "请继续", Toast.LENGTH_SHORT).show()
//                    Log.d("btn_dialog5","btn_dialog5")
//                    println("btn_dialog5")
//                }
                builder4.setTitle("请先登陆").setView(view).show()
            }
        }
    }
}