package com.example.projecttwitch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.projecttwitch.R
import com.example.projecttwitch.viewmodel.StreamViewModel

class LiveFragment : Fragment() {

    lateinit var model: StreamViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lives, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = ViewModelProviders.of(this)[StreamViewModel::class.java]
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        model.load()
    }
}
