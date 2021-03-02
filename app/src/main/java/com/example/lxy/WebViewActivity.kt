package com.example.lxy

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webView = findViewById<WebView>(R.id.web_view)
        webView.webViewClient = MyWebViewClient()
        webView.webChromeClient = MyWebChromeClient()
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.cacheMode = LOAD_CACHE_ELSE_NETWORK
//        webView.loadUrl("file:///andriod_asset/test.html")
        webView.loadUrl("https://m.baidu.com")
        println("打开网页")

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean
    {
        if(keyCode==KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebViewClient: WebViewClient(){
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            if (request != null) {
                view?.loadUrl(request.url.toString())
            }
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            println("onPageStarted")
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            println("onPageFinished")
            view?.loadUrl("javascript:alert('hello')")
        }
    }

    class MyWebChromeClient: WebChromeClient(){
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }

        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
//            if (view != null) {
//                view.tag = title
//            }
        }
    }

}

