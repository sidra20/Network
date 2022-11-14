package com.sidrakotlin.internetdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sidrakotlin.internetdata.databinding.FragmentListBinding
import com.sidrakotlin.internetdata.model.MyViewModel


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


}