package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstrucationsBinding

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 21/12/2021
 */
class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstrucationsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instrucations, container, false
        )
        binding.apply {
            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_instructionsFragment_to_shoeListingFragment)
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
                findNavController().navigate(R.id.action_instructionsFragment_to_loginFragment)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}