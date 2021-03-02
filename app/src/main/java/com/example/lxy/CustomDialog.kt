package com.example.lxy

import android.app.Dialog
import android.content.Context
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi


class CustomDialog: Dialog, View.OnClickListener {
    private lateinit var mTvTitle:  TextView
    private lateinit var mTvMessage:  TextView
    private var title: String? = null
    private var message: String? = null
    private var cancel: String? = null
    private var confirm: String? = null
    private  var cancelListener: IOnCancelListener? = null
    private  var confirmListener: IOnConfirmListener? = null

    constructor(context: Context) : super(context){
    }
    constructor(context: Context, themeResId: Int) : super(context, themeResId){
    }

    fun setTitle(title: String): CustomDialog {
        this.title = title
        return this
    }
    fun setMessage(message: String): CustomDialog {
        this.message = message
        return this
    }
    fun setCancel(cancel: String, listener: IOnCancelListener): CustomDialog {
        this.cancel = cancel
        this.cancelListener = listener
        return this
    }
    fun setConfirm(confirm: String, listener: IOnConfirmListener): CustomDialog {
        this.confirm = confirm
        this.confirmListener = listener
        return this
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        //设定宽度
        var m: WindowManager? = window?.windowManager
        var d: Display? = m?.defaultDisplay
        var p: WindowManager.LayoutParams? = window?.attributes
        var size: Point = Point()
        d?.getSize(size)
        if (p != null) {
            p.width = (size.x * 0.8).toInt()
        }
//        var width: Int? = window?.windowManager?.currentWindowMetrics?.bounds?.width()
        window?.attributes = p

        val mBtnCancel = findViewById<TextView>(R.id.btn_cancel)
        val mBtnConfirm = findViewById<TextView>(R.id.btn_confirm)
        mBtnCancel.setOnClickListener(this)
        mBtnConfirm.setOnClickListener(this)
        mTvTitle = findViewById<TextView>(R.id.tv_good)
        mTvMessage = findViewById<TextView>(R.id.tv_message)

        if (!TextUtils.isEmpty(title)){
            mTvTitle.text = title
        }
        if (!TextUtils.isEmpty(message)){
            mTvMessage.text = message
        }
        if (!TextUtils.isEmpty(cancel)){
            mBtnCancel.text = cancel
        }
        if (!TextUtils.isEmpty(confirm)){
            mBtnConfirm.text = confirm
        }

    }

    interface IOnCancelListener{
        fun onCancel(dialog: CustomDialog)
    }
    interface IOnConfirmListener{
        fun onConfirm(dialog: CustomDialog)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_cancel -> {
                if (cancelListener != null) {
                    cancelListener?.onCancel(this)
                }
            }
            R.id.btn_confirm -> {
                if (confirmListener != null) {
                    confirmListener?.onConfirm(this)
                }
            }
        }
    }

}


