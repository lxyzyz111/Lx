package com.example.lxy

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class BActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Log.d("BActivity","----onCreate()----")
        Log.d("BActivity,taskID:"+taskId,"      harsh:"+hashCode())
        logtaskName()
        val mBtnFinish_2 = findViewById<Button>(R.id.btn_finish_2)
        var mTextView = findViewById<TextView>(R.id.textView)
        val mBtnFinish = findViewById<Button>(R.id.btn_finish)
        var bundle: Bundle? = intent.getBundleExtra("数据传递")
        var name: String? = bundle?.getString("name")
        var number: Int? = bundle?.getInt("number")
        mTextView.text = name + number
        mBtnFinish.setOnClickListener{
            var intent: Intent = Intent()
            var bundle: Bundle = Bundle()
            bundle.putString("message","我回来了")
            intent.putExtra("数据传递",bundle)
            setResult(Activity.RESULT_OK,intent)
            finish()
            Log.d("mBtnFinish","我回来了")
        }
        mBtnFinish_2.setOnClickListener {
            var intent: Intent = Intent(this@BActivity, BActivity::class.java)
            startActivity(intent)
        }
    }
    fun logtaskName(){
        var info: ActivityInfo = packageManager.getActivityInfo(this.componentName, PackageManager.GET_META_DATA)
        Log.d("BActivity",info.taskAffinity)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("BActivity","----onNewIntent()----")
        Log.d("BActivity,taskID:"+taskId,"      harsh:"+hashCode())
        logtaskName()
    }
}