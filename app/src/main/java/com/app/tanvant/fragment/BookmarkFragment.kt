package com.app.tanvant.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.tanvant.R
import com.app.tanvant.adapter.ProductListAdapter
import com.app.tanvant.databinding.FragmentBookmarkBinding
import com.app.tanvant.viewmodel.ProductDbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment(R.layout.fragment_bookmark) {

    private var _binding : FragmentBookmarkBinding? = null
    private val binding get() = _binding!!
    private val dbModle : ProductDbViewModel by viewModels()
    private lateinit var productListAdapter : ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        productListAdapter = ProductListAdapter()
        binding.recyclerViewBookmark.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = productListAdapter
        }

        dbModle.allProductList.observe(requireActivity()) { productList ->
            productListAdapter.productList = productList
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

}