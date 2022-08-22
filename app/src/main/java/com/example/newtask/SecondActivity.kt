package com.example.newtask
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.charset.Charset
class SecondActivity:AppCompatActivity() {
    var name_arr: ArrayList<String> = ArrayList()
    var thought_arr: ArrayList<String> = ArrayList()
    var image_url: ArrayList<String> = ArrayList()
    lateinit var adp:GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        loaddata()
        val recyclerView = findViewById<RecyclerView>(R.id.grid_recv)
        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = gridLayoutManager
         adp = GridAdapter(this, image_url, name_arr, thought_arr)
        recyclerView.adapter = adp
        display()
    }
    private fun display(){
    try {
        val obj = JSONObject(loaddata())
        val arr = obj.getJSONArray("Thoughts")
        for (i in 0 until arr.length()) {
            val mn = arr.getJSONObject(i)
            image_url.add(mn.getString("thumbnil"))
            name_arr.add(mn.getString("author"))
            thought_arr.add(mn.getString("thought"))

        }
    } catch (e: JSONException) {
        e.printStackTrace()
    }
}

    private fun loaddata(): String {
        val json: String?
        try {
            val input: InputStream = assets.open("file.json")
            val size = input.available()
            val buf = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            input.read(buf)
            input.close()
            json = String(buf, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}