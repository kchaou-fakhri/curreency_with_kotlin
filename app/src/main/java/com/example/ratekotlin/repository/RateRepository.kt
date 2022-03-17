package com.example.ratekotlin.repository


import com.example.ratekotlin.MainActivity
import com.example.ratekotlin.data.Currency
import com.example.ratekotlin.data.Retrofit
import com.example.ratekotlin.model.Rate

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class RateRepository(mainActivity: MainActivity) {
   var _mainActivity = mainActivity
    lateinit var listOfcurrency :  HashMap<String,String>
    var _listOfcurrency : ArrayList<com.example.ratekotlin.model.Rate> = arrayListOf()

    fun getData(){



        val service = Retrofit.getInstance().create(Currency::class.java)
        MainScope().launch {

            var response = service.getCurrency()
            listOfcurrency = response.body()?.data as HashMap<String,String>
            listOfcurrency.put("USA","1")
            for ((k, v) in listOfcurrency) {
                var rate = Rate()
                rate.id = k
                rate.value = v
                _listOfcurrency.add(rate)
            }
            _mainActivity.showInView(_listOfcurrency)
            _mainActivity.showRates(_listOfcurrency)
        }
    }

    fun convert(base: Double, _base_convert: String) {
        var base_convert =0.0
        var temp = 0.0
        var temp_convert = 0.0
        base_convert = (listOfcurrency.get(_base_convert)).toString().toDouble()

        for (rate in _listOfcurrency){
            temp = listOfcurrency.get(rate.id).toString().toDouble()
            temp_convert = temp/base_convert


            rate.value =(temp_convert*base).toString()
            _mainActivity.showInView(_listOfcurrency)
        }

    }
}