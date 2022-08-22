package com.example.newtask
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newtask.storage.UserDb
import com.example.newtask.storage.UserEntity
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
class MainActivity : AppCompatActivity() {
    var name_arr: ArrayList<String> = ArrayList()
    var thought_arr: ArrayList<String> = ArrayList()
    var image_url: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previewid.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
    }
    checklistid.setOnClickListener {
        val intent= Intent(this,OpenActivity::class.java)
        startActivity(intent)
    }
    }

}




