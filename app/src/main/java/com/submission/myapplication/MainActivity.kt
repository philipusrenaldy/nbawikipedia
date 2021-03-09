package com.submission.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.recyclerview)
        rv.layoutManager = LinearLayoutManager(this)
        val data = TeamData()
        rv.adapter = Adapter(data.teamdetail)
    }

    override fun onCreateOptionsMenu(topbar: Menu?): Boolean {
        super.onCreateOptionsMenu(topbar)
        menuInflater.inflate(R.menu.profile,topbar)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutdeveloper -> {
                val intent = Intent(this, AboutUs::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
