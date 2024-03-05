package com.example.solutionx

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.models.Country
import com.example.solutionx.models.Currency
import com.example.solutionx.models.Filter

class Adapter(val context: Context,
              private val dataListCountry: List<Country>,
              private val dataListCurrency: List<Currency>,
              private val dataListFilter: List<Filter>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    var selectedIndex : Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_recyle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        if (selectedIndex == position){
            holder.imageCheck.visibility = View.VISIBLE
        }else{
            holder.imageCheck.visibility = View.INVISIBLE
        }
        if (dataListCurrency.isEmpty() && dataListFilter.isEmpty()){
            holder.txtCurrency.text = dataListCountry[position].currency.toString()
            holder.txtCountry.text = dataListCountry[position].name.toString()
            holder.txtCode.text = dataListCountry[position].code.toString()
        }
        else if (dataListCountry.isEmpty() && dataListFilter.isEmpty()){
            holder.txtCountry.text = dataListCurrency[position].name.toString()
            holder.txtCurrency.text = dataListCurrency[position].sign.toString()
            holder.txtCode.text = dataListCurrency[position].code.toString()
        }
        else{
            holder.txtCountry.text = dataListFilter[position].name.toString()
            holder.txtCurrency.visibility = View.INVISIBLE
            holder.txtCode.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        if (dataListCurrency.isEmpty() && dataListFilter.isEmpty()){
            return dataListCountry.size
        }
        else if (dataListCountry.isEmpty() && dataListFilter.isEmpty()){
            return dataListCurrency.size
        }
        else{
            return dataListFilter.size
        }
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val txtCountry : TextView
        val txtCurrency : TextView
        val txtCode : TextView
        val imageCheck : ImageView

        init {
            txtCountry = itemView.findViewById(R.id.txt_country)
            txtCurrency  = itemView.findViewById(R.id.txt_currency)
            txtCode  = itemView.findViewById(R.id.txt_code)
            imageCheck = itemView.findViewById(R.id.image_check)

            itemView.setOnClickListener{
                selectedIndex = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

}