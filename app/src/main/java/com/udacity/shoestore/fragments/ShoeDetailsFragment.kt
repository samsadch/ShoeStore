package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 21/12/2021
 */
class ShoeDetailsFragment : Fragment() {
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel

        viewModel.cancelEvent.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().popBackStack()
                viewModel.onCancelPressed(false)
            }
        })
        binding.apply {
            saveButton.setOnClickListener {
                val shoeName = shoeNameEdt.text.toString()
                val shoeCompany = companyEdt.text.toString()
                val shoeSize = showSizeEdt.text.toString()
                val description = descriptionEdt.text.toString()
                if (shoeName.isNotEmpty() && shoeCompany.isNotEmpty() && shoeSize.isNotEmpty() && description.isNotEmpty()) {
                    viewModel.addShoe(shoeName, shoeCompany, shoeSize, description)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }
}