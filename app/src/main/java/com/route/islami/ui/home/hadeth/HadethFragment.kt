package com.route.islami.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.Constants
import com.route.islami.databinding.HadethFragmentBinding
import com.route.islami.ui.home.hadethDetails.HadethDetailsActivity

class HadethFragment : Fragment() {
    lateinit var viewBinding: HadethFragmentBinding
    lateinit var hadethAdapter: HadethAdapter
    val hadethList : MutableList<Hadeth> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = HadethFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        hadethAdapter = HadethAdapter(hadethList)
        viewBinding.rvHadethName.adapter = hadethAdapter
        navigateToHadethDetails()
    }

    private fun navigateToHadethDetails() {
        hadethAdapter.onHadethClickListener = HadethAdapter.OnHadethClickListener{hadeth,hadethIndex->
            val intent = Intent(activity,HadethDetailsActivity::class.java)
            intent.putExtra(Constants.hadeth,hadeth)
            startActivity(intent)
        }
    }
    private fun readHadethFile() {
        val streamInput = context?.assets?.open("ahadeeth.txt")
        val fileContent = streamInput?.bufferedReader().use { it?.readText() }
        val allAHadeth = fileContent?.trim()?.split("#")
        allAHadeth?.forEach{hadeth->
            val lines = hadeth.trim().split("\n")
            val hadethName = lines[0]
            val newList = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = newList.joinToString ("\n")
            hadethList.add(Hadeth(hadethName,content))
        }
    }


}