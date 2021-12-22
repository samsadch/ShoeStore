package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 20/12/2021
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        binding.apply {
            loginButton.setOnClickListener {
                validateFields(this, it)
            }
            registerButton.setOnClickListener {
                validateFields(this, it)
            }
        }
        return binding.root
    }

    private fun validateFields(binding: FragmentLoginBinding, view: View) {
        binding.apply {
            val username = userNameEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                //navigate
                view.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_login),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}