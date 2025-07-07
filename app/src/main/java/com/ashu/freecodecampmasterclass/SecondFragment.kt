package com.ashu.freecodecampmasterclass

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs


class SecondFragment : Fragment(R.layout.second_fragment) {
    private val args: SecondFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.textViewMessage)
        textView.text = args.messageX
    }
}