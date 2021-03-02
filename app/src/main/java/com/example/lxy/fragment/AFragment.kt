package com.example.lxy.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lxy.R

class AFragment: Fragment() {
    lateinit var mTextView : TextView
    lateinit var mBtnChange: TextView
    lateinit var mBtnReset: TextView
    lateinit var mTextTansport: TextView
    lateinit var listener: IOnMessageClick
    var bFragment: BFragment = BFragment()
    fun newInstance(title: String): AFragment{//实例化传参数
        val fragment: AFragment = AFragment()
        var bundle: Bundle = Bundle()
        bundle.putString("title", title)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_a, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTextView = view.findViewById(R.id.textView_a)
        mBtnChange = view.findViewById<TextView>(R.id.btn_change)
        mBtnReset = view.findViewById<TextView>(R.id.btn_reset)
        mTextTansport = view.findViewById<TextView>(R.id.tv_trans)
        if (activity != null){
            mTextView.setText(arguments?.getString("title"))//显示传过来的参数
        }

        mBtnChange.setOnClickListener {
            var fragment: Fragment? = fragmentManager?.findFragmentByTag("a")
            if (fragment != null){
                fragmentManager?.beginTransaction()?.hide(fragment)?.add(R.id.fl_container, bFragment)?.addToBackStack(null)?.commitAllowingStateLoss()
            Log.d("setOnClickListener ", "fragment != null")
            }
            else{
            fragmentManager?.beginTransaction()?.replace(R.id.fl_container, bFragment)?.commitAllowingStateLoss()
                Log.d("setOnClickListener ", "fragment == null")
            }
        }

        mBtnReset.setOnClickListener {
            mTextView.setText("我是新文字")
        }

        mTextTansport.setOnClickListener {
            //传递数据给Activity
//            (activity as ContainerActivity?)!!.setDdata("你好！")  //写法值得学习
            listener.onClick("你好！你好！")
        }
    }

    interface IOnMessageClick{
        fun onClick(text : String){

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as IOnMessageClick   //不太明白
        }catch (e: ClassCastException){
            throw ClassCastException("Activity必须实现IOnMessageClick接口")
        }


    }
//
//    override fun onDetach() {
//        super.onDetach()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        //取消异步
//    }
}