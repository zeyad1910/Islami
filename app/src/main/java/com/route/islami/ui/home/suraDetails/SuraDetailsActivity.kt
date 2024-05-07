package com.route.islami.ui.home.suraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.Constants
import com.route.islami.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraDetailsBinding: ActivitySuraDetailsBinding
    var suraIndex: Int = 0
    lateinit var suraName: String
    lateinit var verseAdapter: VerseAdapter
    val verseList: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        suraDetailsBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(suraDetailsBinding.root)
        suraName = intent.getStringExtra(Constants.suraName) ?: ""
        suraIndex = intent.getIntExtra(Constants.suraIndex, 0)
        setSupportActionBar(suraDetailsBinding.suraToolbar)
        readSuraFiles()
        initViews()
        initRecyclerView()
    }

    private fun readSuraFiles() {
        val inputStream = assets.open("${suraIndex+1}.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val verses = fileContent.trim().split("\n")
        verses.forEachIndexed { index, verse ->
            verseList.add("$verse(${index + 1})")


        }

    }

    private fun initViews() {
        setTitle(null)
        suraDetailsBinding.suraContent.tvSuraTitle.text = suraName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }

    private fun initRecyclerView() {
        verseAdapter = VerseAdapter(verseList)
        suraDetailsBinding.suraContent.rvSuraDetails.adapter = verseAdapter
    }
}