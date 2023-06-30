package com.app.tanvant.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.tanvant.R
import com.app.tanvant.adapter.ProductListAdapter
import com.app.tanvant.databinding.FragmentHomeBinding
import com.app.tanvant.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ProductViewModel by viewModels()
    private lateinit var productListAdapter : ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Intialize", "Intialize")
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("setup", "Intialize")
        setUpRv()
    }

    private fun setUpRv() {

        productListAdapter = ProductListAdapter()
        binding.recyclerViewProduct.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = productListAdapter
        }
        Log.d("Intialize", "Intialize")
        viewModel.productResponse.observe(requireActivity()) { response ->
            productListAdapter.productList = response
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}