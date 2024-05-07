package com.route.islami.ui.home.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.Constants
import com.route.islami.databinding.ActivityHadethDetailsBinding
import com.route.islami.ui.home.hadeth.Hadeth
import com.route.islami.ui.home.hadeth.HadethAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var hadethBinding: ActivityHadethDetailsBinding
    var hadeth: Hadeth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hadethBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(hadethBinding.root)
        getHadeth()
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(hadethBinding.hadethToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle(null)
        hadethBinding.hadethContent.tvHadethTitle.text = hadeth?.title
        hadethBinding.hadethContent.tvHadethDetailsContent.text=hadeth?.content
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }
    private fun getHadeth() {
        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.hadeth, Hadeth::class.java)
        } else {
            intent.getParcelableExtra<Hadeth>(Constants.hadeth)
        }
    }
}