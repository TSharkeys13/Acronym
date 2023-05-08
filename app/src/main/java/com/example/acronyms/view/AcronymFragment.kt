package com.example.acronyms.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.acronyms.databinding.FragmentAcronymBinding
import com.example.acronyms.viewModels.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AcronymFragment : Fragment() {

    private val acronymViewModel by viewModels<AcronymViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentAcronymBinding.inflate(inflater, container, false).apply {
            acronymViewModel = this@AcronymFragment.acronymViewModel
            adapter = LongformAdapter()
            lifecycleOwner = this@AcronymFragment.viewLifecycleOwner
        }.root
    }
}
