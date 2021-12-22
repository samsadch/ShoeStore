package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeContainer
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 21/12/2021
 */
class ShoeListingFragment : Fragment() {
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing, container, false
        )
        binding.addFab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailsFragment)
        }

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        val shoe: Shoe? = ShoeListingFragmentArgs.fromBundle(requireArguments()).shoe
        shoe?.let {
            viewModel.setShoe(shoe)
        }

        viewModel.shoes.observe(requireActivity(), {
            val result = it ?: return@observe
            if (result.size > 0) {
                binding.noItemLabel.visibility = GONE
                shoe?.let {
                    for (shoe in result) {
                        val shoeView = ShoeContainer(requireContext())
                        shoeView.loadShoes(shoe)
                        binding.listContainer.addView(shoeView)
                    }
                }
            } else {
                binding.noItemLabel.visibility = VISIBLE
            }
        })

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