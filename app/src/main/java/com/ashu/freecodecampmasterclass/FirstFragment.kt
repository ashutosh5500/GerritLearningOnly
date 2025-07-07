package com.ashu.freecodecampmasterclass

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment(R.layout.first_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btnNavigate)
        button.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("YOYO")
            findNavController().navigate(action)
        }
    }
}