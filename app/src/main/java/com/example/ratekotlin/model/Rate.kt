package com.example.ratekotlin.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.HashMap

 class Rate(){
     var id : String? =null
     var value : String? = null
     var data: HashMap<String,String>?=null

    fun getCurrency() : HashMap<String,String>? {

        return data
    }


}




