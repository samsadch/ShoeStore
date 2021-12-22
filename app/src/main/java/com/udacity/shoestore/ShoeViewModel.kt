package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

/**
 * @Author: Samsad Chalil Valappil
 * @Date: 22/12/2021
 */
class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>> = _shoes

    init {
        _shoes.value = ArrayList()
    }

    fun setShoe(shoe: Shoe) {
        val tempList = _shoes.value
        if (tempList != null) {
            tempList.add(shoe)
            _shoes.value = tempList
        }
    }
}