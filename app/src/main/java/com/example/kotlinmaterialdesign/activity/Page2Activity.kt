package com.example.kotlinmaterialdesign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinmaterialdesign.R
import kotlinx.android.synthetic.main.activity_page2.*

class Page2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        collTabLayout.title = "水果"
        toolBar.setNavigationOnClickListener { finish() }
    }
}