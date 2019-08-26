package com.example.projecttwitch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projecttwitch.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorPrimary, null))

        bottom_navigation.setOnNavigationItemSelectedListener {  }
    }
}
