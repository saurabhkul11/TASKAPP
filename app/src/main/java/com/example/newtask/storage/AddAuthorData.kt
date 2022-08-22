package com.example.newtask.storage

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_home.*
import androidx.room.Room.databaseBuilder
import com.example.newtask.ListData
import com.example.newtask.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class AddAuthorData:AppCompatActivity() {
    lateinit var db: UserDb
    var list = ArrayList<ListData>()
    var name_arr:ArrayList<String> = ArrayList()
    var thought_arr:ArrayList<String> = ArrayList()
    var image_url:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db= databaseBuilder(applicationContext, UserDb::class.java, "AuthorDB")
            .build()
        savedata()
  val author1=findViewById<TextView>(R.id.txtlistauthor)
        val thought1=findViewById<TextView>(R.id.txtlistthought)
        val image1=findViewById<ImageView>(R.id.img)
    }

     fun savedata() {
        val thread = Thread {
            db.userDao().getData().forEachIndexed{index, userEntity ->
                list.add(ListData(userEntity.id,userEntity.url,
                    userEntity.author,userEntity.thought,userEntity.type))
            }
        }
        thread.start()
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