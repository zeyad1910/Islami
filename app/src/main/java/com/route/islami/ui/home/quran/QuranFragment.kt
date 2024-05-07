package com.route.islami.ui.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.QuranFragmentBinding
import com.route.islami.ui.home.suraDetails.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var viewBinding:QuranFragmentBinding
    lateinit var chapterAdapter: SuraAdapter
    val suraList = mutableListOf<Sura>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = QuranFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        createChapterList()
        chapterAdapter = SuraAdapter(suraList)
        viewBinding.rvSuraName.adapter = chapterAdapter
        chapterAdapter.onSuraClickListener = SuraAdapter.OnSuraClickListener { suraName, position ->
            navigateToSuraDetails(suraName,position)
        }
    }

    private fun navigateToSuraDetails(suraName: String, position: Int) {
        val intent = Intent(activity,SuraDetailsActivity::class.java)
        intent.putExtra(com.route.islami.Constants.suraName,suraName)
        intent.putExtra(com.route.islami.Constants.suraIndex,position)
        startActivity(intent)
    }

    private fun createChapterList(){
        for (i in Sura().suraName)
            suraList.add(Sura())
    }
}