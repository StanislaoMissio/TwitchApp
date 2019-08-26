package com.example.projecttwitch.view

import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.projecttwitch.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.white, null))

        val fragmentManager = supportFragmentManager

        val fragmentProfile = ProfileFragment()
        val fragmentConfig = ConfigurationFragment()
        val fragmentGames = GamesFragment()
        val fragmentLives = LiveFragment()

        fragmentManager.beginTransaction().add(R.id.fragment_main_container, fragmentLives, "4")
            .hide(fragmentLives).commit()
        fragmentManager.beginTransaction().add(R.id.fragment_main_container, fragmentGames, "3")
            .hide(fragmentGames).commit()
        fragmentManager.beginTransaction().add(R.id.fragment_main_container, fragmentConfig, "2")
            .hide(fragmentConfig).commit()
        fragmentManager.beginTransaction().add(R.id.fragment_main_container, fragmentProfile, "1")
            .commit()

        var activeFragment = Fragment()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_profile -> {
                    fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(fragmentProfile)
                        .commit()
                    activeFragment = ProfileFragment()
                    true
                }
                R.id.action_config -> {
                    fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(fragmentConfig)
                        .commit()
                    activeFragment = ConfigurationFragment()
                    true
                }
                R.id.action_games -> {
                    fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(fragmentGames)
                        .commit()
                    activeFragment = GamesFragment()
                    true
                }
                R.id.action_live -> {
                    fragmentManager.beginTransaction()
                        .hide(activeFragment)
                        .show(fragmentLives)
                        .commit()
                    activeFragment = LiveFragment()
                    true
                }
                else -> false
            }
        }
    }
}
