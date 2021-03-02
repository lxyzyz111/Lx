package com.example.lxy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class StaggeredGridAdapter(private val context: Context, private val listener:OnItemClickListener)
    :RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.pu_view_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 !=0){
            holder.img.setImageResource(R.drawable.img_07951)
        }
        else{
            holder.img.setImageResource(R.drawable.img_1138)
        }
//        println(position)
        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "点击了.." + position, Toast.LENGTH_SHORT).show()
            listener.onClick(position)
         }
    }

    override fun getItemCount(): Int {
        return 30
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.imageView_pu)
    }

    interface OnItemClickListener {
        fun onClick(pos: Int)
    }

}



