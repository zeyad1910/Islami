package com.route.islami.ui.home.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.QuranFragmentBinding
import com.route.islami.databinding.RadioFragmentBinding

class RadioFragment : Fragment() {
    lateinit var viewBinding: RadioFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = RadioFragmentBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}