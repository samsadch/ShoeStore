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

    private fun setShoe(shoe: Shoe?) {
        shoe?.let {
            val tempList = _shoes.value
            if (tempList != null) {
                tempList.add(shoe)
                _shoes.value = tempList
                onCancelPressed(true)
            }
        }
    }

    fun clearShoe(){
        _currentShoe.value = Shoe("",0.0,"","")
    }

    fun setShoeName(shoeName: String) {
        val shoe = Shoe(
            name = shoeName,
            size = _currentShoe.value?.size ?: 0.0,
            company = _currentShoe.value?.company ?: "",
            description = _currentShoe.value?.description ?: ""
        )
        _currentShoe.value = shoe
    }

    fun setShoeCompany(company: String) {
        val shoe = Shoe(
            name = _currentShoe.value?.name ?: "",
            size = _currentShoe.value?.size ?: 0.0,
            company = company,
            description = _currentShoe.value?.description ?: ""
        )
        _currentShoe.value = shoe
    }

    fun setShoeSize(size: Double) {
        val shoe = Shoe(
            name = _currentShoe.value?.name ?: "",
            size = size,
            company = _currentShoe.value?.company ?: "",
            description = _currentShoe.value?.description ?: ""
        )
        _currentShoe.value = shoe
    }

    fun setShoeDescription(description: String) {
        val shoe = Shoe(
            name = _currentShoe.value?.name ?: "",
            size = _currentShoe.value?.size ?: 0.0,
            company = _currentShoe.value?.company ?: "",
            description = description
        )
        _currentShoe.value = shoe
    }

    fun addShoe() {
        setShoe(_currentShoe.value)
    }

    fun onCancelPressed(isCancel: Boolean) {
        _cancelEvent.value = isCancel
    }
}