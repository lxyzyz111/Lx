package com.example.lxy

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CustomDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_dialog)
        val mBtnMyDialog = findViewById<Button>(R.id.btn_myDialog)
        mBtnMyDialog.setOnClickListener {
            var customDialog = CustomDialog(this@CustomDialogActivity)
            customDialog.setTitle("提示").setMessage("确认删除此项吗？")
            customDialog.setCancel("取消",object : CustomDialog.IOnCancelListener {
                override fun onCancel(dialog: CustomDialog) {
                }
            })
            customDialog.setConfirm("确定",object : CustomDialog.IOnConfirmListener {
                override fun onConfirm(dialog: CustomDialog) {
                }
            })
            customDialog.show()
            Log.d("11111111111","执行了按钮")
        }
    }
}