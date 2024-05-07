package com.route.islami.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.route.islami.R
import com.route.islami.databinding.ActivityMainBinding
import com.route.islami.ui.home.hadeth.HadethFragment
import com.route.islami.ui.home.quran.QuranFragment
import com.route.islami.ui.home.radio.RadioFragment
import com.route.islami.ui.home.tasbeh.TasbehFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {

        viewBinding.content.bottomNav.setOnItemSelectedListener {
            val fragment:Fragment = when (it.itemId){
                R.id.quran_navigation -> QuranFragment()
                R.id.hadeth_navigation -> HadethFragment()
                R.id.tasbeh_navigation -> TasbehFragment()
                R.id.radio_navigation -> RadioFragment()
                else -> QuranFragment()
            }
            pushFragment(fragment)
            true
        }
        pushFragment(QuranFragment())
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}