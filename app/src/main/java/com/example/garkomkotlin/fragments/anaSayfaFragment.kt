package com.example.garkomkotlin.fragments

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.garkomkotlin.R
import com.example.garkomkotlin.databinding.FragmentAnaSayfaBinding


class anaSayfaFragment : Fragment() {

    private var _binding : FragmentAnaSayfaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnaSayfaBinding.inflate(inflater,container,false)
        val htmlString1 = "<u>İŞ ARIYORUM</u>"
        binding.idIsAriyorum.setText(Html.fromHtml(htmlString1))
        binding.idIsAriyorum.setOnClickListener {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.main_container,isAriyorumFragment())?.commit()
        }

        val htmlString2 = "<u>ÇALIŞAN ARIYORUM</u>"
        binding.idCalisanAriyorum.setText(Html.fromHtml(htmlString2))
        binding.idCalisanAriyorum.setOnClickListener {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.main_container,calisanAriyorumFragment())?.commit()
        }



        return binding.root
    }


}