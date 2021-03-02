package com.example.lxy

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Log.d("AActivity","----onCreate()----")
        Log.d("AActivity,taskID:"+taskId,"      harsh:"+hashCode())
        logtaskName()
        val mBtnJump = findViewById<Button>(R.id.btn_jump_1)
        val mBtnJunm_2 = findViewById<Button>(R.id.btn_jump_2)
        mBtnJunm_2.setOnClickListener {
            var intent: Intent = Intent(this@AActivity, AActivity::class.java)
            startActivity(intent)
        }
        mBtnJump.setOnClickListener{
            var intent: Intent = Intent(this@AActivity, BActivity::class.java)
            var bundle: Bundle = Bundle()
            bundle.putString("name","刘德华")
            bundle.putInt("number",12345)
            intent.putExtra("数据传递",bundle)
            startActivity(intent)
//            startActivityForResult(intent,0)
            //显示1
//            var intent: Intent = Intent(this@AActivity, BActivity::class.java)
//            startActivity(intent)
            //显示2
//            var intent: Intent = Intent()
//            intent.setClass(this@AActivity, BActivity::class.java)
//            startActivity(intent)
            //显示3
//            var intent: Intent = Intent()
//            intent.setClassName(this@AActivity, "com.example.lxy.BActivity")
//            startActivity(intent)
            //显示4
//            var intent: Intent = Intent()
//            intent.component = ComponentName(this@AActivity, "com.example.lxy.BActivity")
//            startActivity(intent)
            //隐式
//            var intent: Intent = Intent()
//            intent.setAction("com.lxy.test")
//            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            Toast.makeText(this, data.getBundleExtra("数据传递")?.getString("message"),Toast.LENGTH_LONG).show()
            Log.d("onActivityResult","onActivityResult")
        }
    }

    fun logtaskName(){
        var info: ActivityInfo = packageManager.getActivityInfo(this.componentName, PackageManager.GET_META_DATA)
        Log.d("AActivity",info.taskAffinity)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("AActivity","----onNewIntent()----")
        Log.d("AActivity,taskID:"+taskId,"      harsh:"+hashCode())
        logtaskName()
    }
}