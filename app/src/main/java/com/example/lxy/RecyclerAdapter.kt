package com.example.lxy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, private val data: ArrayList<Int>,private val listener:OnItemClickListener)
    :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.recycler_view_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(data[position])
//        println(position)
        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "点击了.." + position, Toast.LENGTH_SHORT).show()
            listener.onClick(position)
         }
    }

    override fun getItemCount(): Int {
        return data.size//Int.MAX_VALUE    //
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.imageView)
    }

    interface OnItemClickListener {
        fun onClick(pos: Int)
    }

}



