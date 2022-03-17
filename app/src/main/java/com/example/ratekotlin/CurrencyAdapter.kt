package com.example.ratekotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ratekotlin.model.Rate


class CurrencyAdapter(
    val context: Context,
    private val listCurrency: ArrayList<Rate>
) : RecyclerView.Adapter
    <CurrencyAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int){

            holder.bindView(listCurrency[position])
        }
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun  bindView(data: Rate){

             itemView.findViewById<TextView>(R.id.id).text = data.id
                itemView.findViewById<TextView>(R.id.value).text =data.value
//                itemView.setOnClickListener {
//                    val intent = Intent(context, MainActivity2::class.java).apply {
//                        putExtra("success", data.data)
//
//                    }
//                    context.startActivity(intent)
//
//                }
            }
        }

        override fun getItemCount(): Int {
            return listCurrency.size
        }


    }