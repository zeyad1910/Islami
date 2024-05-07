package com.route.islami.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.R
import com.route.islami.databinding.TasbehFragmentBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: TasbehFragmentBinding
    var counter = 0
    var currentDhikrListIndex = 0
    lateinit var dhikrList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = TasbehFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dhikrList = resources.getStringArray(R.array.dhikr_list).toMutableList()
        setOnClickBodyOfSebha()
        setOnClickTextViewOfDhikr()

    }

    fun changeDhikr() {
        if (counter < 33) {
            counter++
        } else {
            counter = 0
            currentDhikrListIndex =
                if (currentDhikrListIndex < dhikrList.size - 1) ++currentDhikrListIndex else 0
            viewBinding.tvDhikr.text = dhikrList[currentDhikrListIndex]
        }
        viewBinding.tvNumberOfDhikr.text = counter.toString()
    }

    fun setOnClickBodyOfSebha() {
        viewBinding.ivBodyOfSeb7a.setOnClickListener {
            viewBinding.ivBodyOfSeb7a.rotation += (360 / 33).toFloat()
            changeDhikr()

        }
    }

    fun setOnClickTextViewOfDhikr() {
        viewBinding.tvDhikr.setOnClickListener {
            viewBinding.ivBodyOfSeb7a.rotation += (360 / 33).toFloat()
            changeDhikr()

        }
    }
}