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

    private val _currentShoe = MutableLiveData<Shoe>()
    val currentShoe: LiveData<Shoe> = _currentShoe


    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>> = _shoes

    private val _cancelEvent = MutableLiveData<Boolean>()
    val cancelEvent: LiveData<Boolean> = _cancelEvent

    init {
        _shoes.value = ArrayList()
        onCancelPressed(false)
    }

    private fun setShoe(shoe: Shoe) {
        val tempList = _shoes.value
        if (tempList != null) {
            tempList.add(shoe)
            _shoes.value = tempList
            onCancelPressed(true)
        }
    }

    fun addShoe(shoeName: String, shoeCompany: String, shoeSize: String, description: String) {
        val shoe = Shoe(
            name = shoeName,
            size = shoeSize.toDouble(),
            company = shoeCompany,
            description = description
        )
        setShoe(shoe)
    }

    fun onCancelPressed(isCancel: Boolean) {
        _cancelEvent.value = isCancel
    }
}