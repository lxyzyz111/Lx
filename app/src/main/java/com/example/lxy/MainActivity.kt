package com.example.lxy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.lxy.fragment.ContainerActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mBtnTextView = findViewById<Button>(R.id.btn_textView)
        mBtnTextView.setOnClickListener(this)
        val mBtnRecyclerView = findViewById<Button>(R.id.btn_recyclerView)
        mBtnRecyclerView.setOnClickListener(this)
        val mBtnPubuliu = findViewById<Button>(R.id.btn_pu_recyclerView)
        mBtnPubuliu.setOnClickListener(this)
        val mBtnNewRecyclerView = findViewById<Button>(R.id.btn_new_recyclerView)
        mBtnNewRecyclerView.setOnClickListener(this)
        val mBtnWebView = findViewById<Button>(R.id.btn_webView)
        mBtnWebView.setOnClickListener(this)
        val mBtnToast = findViewById<Button>(R.id.btn_toast)
        mBtnToast.setOnClickListener(this)
        val mBtnDialog = findViewById<Button>(R.id.btn_dialog)
        mBtnDialog.setOnClickListener(this)
        val mBtnProgressBar = findViewById<Button>(R.id.btn_progressbar)
        mBtnProgressBar.setOnClickListener(this)
        val mBtnCustomDialog = findViewById<Button>(R.id.btn_customDialog)
        mBtnCustomDialog.setOnClickListener(this)
        val mBtnPopup = findViewById<Button>(R.id.btn_Popup)
        mBtnPopup.setOnClickListener(this)
        val mBtnLife = findViewById<Button>(R.id.btn_life)
        mBtnLife.setOnClickListener(this)
        val mBtnjump = findViewById<Button>(R.id.btn_jump)
        mBtnjump.setOnClickListener(this)
        val mBtnfragment = findViewById<Button>(R.id.btn_fragment)
        mBtnfragment.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent: Intent? = null
        when (v?.id) {
            R.id.btn_textView -> {
                intent = Intent(this@MainActivity, TextViewActivity::class.java)
            }
            R.id.btn_recyclerView -> {
                intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            }
            R.id.btn_pu_recyclerView -> {
                intent = Intent(this@MainActivity, PubuliuActivity::class.java)
            }
            R.id.btn_new_recyclerView-> {
                intent = Intent(this@MainActivity, NewRecyclerActivity::class.java)
            }
            R.id.btn_webView-> {
                intent = Intent(this@MainActivity, WebViewActivity::class.java)
            }
            R.id.btn_toast-> {
                intent = Intent(this@MainActivity, ToastActivity::class.java)
            }
            R.id.btn_dialog-> {
                intent = Intent(this@MainActivity, DialogActivity::class.java)
            }
            R.id.btn_progressbar-> {
                intent = Intent(this@MainActivity, ProgressActivity::class.java)
            }
            R.id.btn_customDialog-> {
                intent = Intent(this@MainActivity, CustomDialogActivity::class.java)
            }
            R.id.btn_Popup-> {
                intent = Intent(this@MainActivity, PopupActivity::class.java)
            }
            R.id.btn_life-> {
                intent = Intent(this@MainActivity, LifeCycleActivity::class.java)
            }
            R.id.btn_jump-> {
                intent = Intent(this@MainActivity, AActivity::class.java)
            }
            R.id.btn_fragment-> {
                intent = Intent(this@MainActivity, ContainerActivity::class.java)
            }
        }
        startActivity(intent)
    }
}

