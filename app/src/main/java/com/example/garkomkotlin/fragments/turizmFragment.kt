package com.example.garkomkotlin.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.garkomkotlin.R
import com.example.garkomkotlin.databinding.FragmentTurizmBinding


class turizmFragment : Fragment() {
    private var _binding : FragmentTurizmBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTurizmBinding.inflate(inflater,container,false)
        val htmlString2 = "<u>Buradan çalışan hesabı oluşturaabilirsiniz.</u>"
        binding.idHesap.setText(Html.fromHtml(htmlString2))
        return binding.root
    }


}