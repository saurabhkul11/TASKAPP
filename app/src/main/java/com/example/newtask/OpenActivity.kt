package com.example.newtask

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class OpenActivity:AppCompatActivity() {

    var name_arr:ArrayList<String> = ArrayList()
    var thought_arr:ArrayList<String> = ArrayList()
    var image_url:ArrayList<String> = ArrayList()
    var type_arr:ArrayList<String> = ArrayList()
    lateinit var adp:SimpleAdapter
    // lateinit var list: MutableList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loaddata()
        val recyclerView = findViewById<RecyclerView>(R.id.rec)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        adp = SimpleAdapter(this,image_url,name_arr,thought_arr)
        recyclerView.adapter = adp
        display()
     /* imgshare.setOnClickListener {
           sharedata()
       }*/

    }
    private fun display()
    {
        try {
            val obj = JSONObject(loaddata())
            val arr = obj.getJSONArray("Thoughts")
            for (i in 0 until arr.length()) {
                val mn = arr.getJSONObject(i)
                image_url.add(mn.getString("thumbnil"))
                name_arr.add(mn.getString("author"))
                thought_arr.add(mn.getString("thought"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun sharedata() {
        val author1=findViewById<TextView>(R.id.txtlistauthor).toString()
        val thought1=findViewById<TextView>(R.id.txtlistauthor).toString()
        val msg:String="$author1:" + "$thought1"
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "$msg")
        startActivity(Intent.createChooser(shareIntent, "Share link using"))
    }



    private fun loaddata():String{
        val json: String?
        try {
            val input: InputStream = assets.open("file.json")
            val size = input.available()
            val buf = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            input.read(buf)
            input.close()
            json = String(buf, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}
/*fun savedata(){
        val author1=findViewById<TextView>(R.id.txtauthor)
        val thought1=findViewById<TextView>(R.id.txtthought)
        // val type:String=""
        val pic1=findViewById<ImageView>(R.id.pic)
        GlobalScope.launch {

    }}*/

