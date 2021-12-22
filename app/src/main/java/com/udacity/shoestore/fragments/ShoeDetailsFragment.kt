package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 21/12/2021
 */
class ShoeDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )
        binding.apply {
            saveButton.setOnClickListener {
                val shoeName = shoeNameEdt.text.toString()
                val shoeCompany = comapnyEdt.text.toString()
                val shoeSize = showSizeEdt.text.toString()
                val description = descriptionEdt.text.toString()
                if (shoeName.isNotEmpty() && shoeCompany.isNotEmpty() && shoeSize.isNotEmpty() && description.isNotEmpty()) {
                    val shoe = Shoe(
                        name = shoeName,
                        size = shoeSize.toDouble(),
                        company = shoeCompany,
                        description = description
                    )
                    requireView().findNavController()
                        .navigate(
                            ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListingFragment(
                                shoe
                            )
                        )
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            cancelButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_logout, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_logout -> {
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}