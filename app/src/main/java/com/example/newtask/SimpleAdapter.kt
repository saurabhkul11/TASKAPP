package com.example.newtask
import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SimpleAdapter(private var context: Context,
                    private var images:ArrayList<String>,
                 private var author: ArrayList<String>,
                 private var thought: ArrayList<String>,
                    ) :RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Author_name.text = author[position]
        holder.Thought.text = thought[position]
        Picasso.with(context).load(images[position]).into(holder.Pic)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item selected", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return author.size
    }
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    {
       // var btn:ImageView=itemView.findViewById(R.id.imgshare)
        var Author_name: TextView = itemView.findViewById<View>(R.id.txtlistauthor) as TextView
        var Thought: TextView = itemView.findViewById<View>(R.id.txtlistthought) as TextView
        var Pic: ImageView = itemView.findViewById<View>(R.id.img) as ImageView

    }


    }
    class ext{
    fun ab(){
        val a='w'
        print(a)
    }

    }
    fun ext.fg(){
    print("extension")
    }


