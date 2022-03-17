package com.example.ratekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ratekotlin.model.Rate
import com.example.ratekotlin.viewmodel.CurrencyViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


   private var currencyVM = CurrencyViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        currencyVM.getData()


        btn_convert.setOnClickListener{
            currencyVM.convert(base.text.toString().toDouble(),menu.text.toString())
        }


    }
     fun showInView(arrayWithData: ArrayList<Rate>) {
        val adapter=CurrencyAdapter(this,arrayWithData)
        recyclerViewer.layoutManager = LinearLayoutManager(this)
        recyclerViewer.adapter=adapter
    }

    fun showRates(list: ArrayList<Rate>) {
        var _list = ArrayList<String>()

        for (item in list) {
            _list.add(item.id.toString())
        }
        val adapter = ArrayAdapter(this,R.layout.simple_dropdown_item_1line,_list)
        menu.setAdapter(adapter)
    }

}