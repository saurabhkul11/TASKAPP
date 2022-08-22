package com.example.newtask

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GridAdapter(private var context: Context,
                  private var images:ArrayList<String>,
                  private var author: ArrayList<String>,
                  private var thought: ArrayList<String>,) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Author_name.text = author[position]
        holder.Thought.text = thought[position]
        Picasso.with(context).load(images[position]).into(holder.Pic)

    }

    override fun getItemCount(): Int {
        return author.size
    }
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var Author_name: TextView = itemView.findViewById<View>(R.id.grid_author)as TextView
        var Thought: TextView = itemView.findViewById<View>(R.id.grid_thought)as TextView
        var Pic: ImageView = itemView.findViewById(R.id.grid_pic)as ImageView
    }



}