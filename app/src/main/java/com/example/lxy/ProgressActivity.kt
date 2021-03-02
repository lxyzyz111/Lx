package com.example.lxy


import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class ProgressActivity : AppCompatActivity() {
    private lateinit var mPb3: ProgressBar
    private lateinit var mBtnStart: Button
    private lateinit var mBtnProgressDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        mPb3 = findViewById<ProgressBar>(R.id.progressBar3)
        mBtnProgressDialog = findViewById<Button>(R.id.progressDialog)
        mBtnStart = findViewById<Button>(R.id.start)
        mBtnStart.setOnClickListener {
            mPb3.progress = 10
            handler.post(scrollRunnable)
        }
        mBtnProgressDialog.setOnClickListener { //ProgressDialog取消了，用ProgressBar替代
            var progressDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        }
    }

    val handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
//        @SuppressLint("HandlerLeak")
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            if (mPb3.progress < 100) {
//
//            } else {
//                Log.d("ProgressActivity", "handler else")
//            }
//        }
    }

    private var scrollRunnable :Runnable = object : Runnable {
        override fun run() {
            mPb3.progress = mPb3.progress + 5
            if (mPb3.progress < 100) {
                handler.postDelayed(this, 500)
                Log.d("mPb3.progress", mPb3.progress.toString())
            } else {
                Log.d("ProgressActivity", "handler else")
            }
        }

    }

}