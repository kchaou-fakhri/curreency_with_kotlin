package com.example.ratekotlin.viewmodel


import com.example.ratekotlin.MainActivity
import com.example.ratekotlin.repository.RateRepository


class CurrencyViewModel(mainActivity: MainActivity) {
    private var currencyRepository = RateRepository(mainActivity)


    fun getData(){
        currencyRepository.getData()
    }
    fun convert(base: Double, base_convert : String){
        currencyRepository.convert(base,base_convert)

    }
}