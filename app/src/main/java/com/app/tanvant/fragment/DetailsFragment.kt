package com.app.tanvant.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.app.tanvant.R
import com.app.tanvant.databinding.FragmentDetailsBinding
import com.app.tanvant.model.ProductResponse

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args : DetailsFragmentArgs by navArgs()
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