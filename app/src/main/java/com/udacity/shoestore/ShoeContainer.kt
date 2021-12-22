package com.udacity.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 22/12/2021
 * samsad.valappil@thedigitalx.ae
 */
class ShoeContainer(context: Context) : LinearLayout(context) {

    private val binding: ShoeItemBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item, this, false)

    fun loadShoes(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeNameEdt.text = shoe.name
            showSizeEdt.text = shoe.size.toInt().toString()
            descriptionEdt.text = shoe.description
            companyEdt.text = shoe.company
        }
    }

}