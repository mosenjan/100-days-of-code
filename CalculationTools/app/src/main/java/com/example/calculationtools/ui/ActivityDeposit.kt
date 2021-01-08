package com.example.calculationtools.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.calculationtools.R
import com.example.calculationtools.databinding.ActivityDepositBinding
import com.example.calculationtools.ui.viewmodels.DepositViewModel


class ActivityDeposit : AppCompatActivity() {
    private lateinit var binding:ActivityDepositBinding
    private lateinit var depositViewModel: DepositViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit)

        depositViewModel = ViewModelProvider(this).get(DepositViewModel::class.java)

        binding.also {
            binding.vm = depositViewModel
            binding.lifecycleOwner = this
        }

        
        binding.btnCalculate.setOnClickListener {

            depositViewModel.setResult()



        }
    }



}