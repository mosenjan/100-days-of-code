package com.example.calculationtools.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculationtools.data.repository.DepositRepository
import kotlinx.coroutines.launch


class DepositViewModel:ViewModel() {

    var days = MutableLiveData<Int>()
    var percent = MutableLiveData<Int>()
    var money = MutableLiveData<Int>()
    var result = MutableLiveData<Int>()

    private val depositRepository = DepositRepository()

    fun setResult(){
        viewModelScope.launch {
            result.postValue(depositRepository.depositResult(15, 25, 25))
        }
    }

}