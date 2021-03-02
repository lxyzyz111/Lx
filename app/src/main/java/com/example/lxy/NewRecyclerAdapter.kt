package com.example.lxy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NewRecyclerAdapter(private val context: Context, private val listener: OnItemClickListener)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0){
            return LinearViewHolder(layoutInflater.inflate(R.layout.recycler_view_items_new, parent, false))
        }
        else{
            return LinearViewHolder2(layoutInflater.inflate(R.layout.recycler_view_items_new_2, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println(position)
        if (getItemViewType(position) == 0){
            (holder as LinearViewHolder).mtextView.text = "Hello World!"
        }
        else{
            (holder as LinearViewHolder2).mtextView.text = "我在奔跑!"
        }
        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "点击了.." + position, Toast.LENGTH_SHORT).show()
            listener.onClick(position)
         }
    }

    override fun getItemCount(): Int {
        return 30//Int.MAX_VALUE    //
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0){
            return 0
        }
        else{
            return 1
        }

    }

    class LinearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mtextView: TextView = itemView.findViewById<TextView>(R.id.text6)
     }

    class LinearViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mtextView: TextView = itemView.findViewById<TextView>(R.id.text5)
        val img = itemView.findViewById<ImageView>(R.id.imageView5)
    }

    interface OnItemClickListener {
        fun onClick(pos: Int)
    }

}



