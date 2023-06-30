package com.app.tanvant.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.app.tanvant.R
import com.app.tanvant.databinding.FragmentDetailsBinding
import com.app.tanvant.model.ProductResponse
import com.app.tanvant.viewmodel.ProductDbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args : DetailsFragmentArgs by navArgs()
    private val productDbViewModel : ProductDbViewModel by viewModels()
    private lateinit var product: ProductResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = args.product

        populateUI()

        binding.addToFavourite.setOnClickListener{mView->
           saveNote(mView)
        }
    }

    private fun saveNote(mView: View?) {
        productDbViewModel.insertProduct(product)
//        val direction = DetailsFragmentDirections.actionDetailsFragmentToBookmarkFragment2()
//        mView!!.findNavController().navigate(direction)
    }

    @SuppressLint("SetTextI18n")
    private fun populateUI() {

        binding.apply {
            image.load(product.image){
                crossfade(true)
                crossfade(1000)
            }
            title.text = product.title
            category.text = product.category
            price.text = "₹ ${product.price.toString()}"
            rating.rating = product.rating.rate.toFloat()
            description.text = product.description
            ratingCount.text = "(${product.rating.count.toString()})"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}