package com.submission.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {

    private lateinit var teamname: TextView
    private lateinit var teamdesc: TextView
    private lateinit var teamprofile: TextView
    private lateinit var teamimage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        teamname = findViewById(R.id.teamname)
        teamdesc = findViewById(R.id.teamdesc)
        teamprofile = findViewById(R.id.teamprofile)
        teamimage = findViewById(R.id.teamimage)
        intent?.let { getDetail() }
    }

    private fun getDetail() {
        title = intent.getStringExtra(TNAME)
        teamname.text = intent.getStringExtra(TNAME)
        teamdesc.text = intent.getStringExtra(TDESC)
        teamprofile.text = intent.getStringExtra(TDETAIL)
        val callImage = intent.getIntExtra(IMAGE, 0)
        Glide.with(this).load(callImage).into(teamimage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val TNAME = "teamname"
        const val IMAGE = "image"
        const val TDETAIL = "profile"
        const val TDESC = "desc"
    }
}