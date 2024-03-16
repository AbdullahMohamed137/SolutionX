package com.example.solutionx

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.uimodule.AdapterData

class Adapter(
    val context: Context,
    private val dataList: ArrayList<AdapterData>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var selectedIndex: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_recyle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.imageCheck.visibility =
            if (selectedIndex == position) View.VISIBLE else View.INVISIBLE
        holder.txtCurrency.text = dataList[position].currency.toString()
        holder.txtName.text = dataList[position].name.toString()
        holder.txtCode.text = dataList[position].code.toString()

        holder.itemView.setOnClickListener {
            selectedIndex =
                if (selectedIndex == position) -1 else position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView
        val txtCurrency: TextView
        val txtCode: TextView
        val imageCheck: ImageView

        init {
            txtName = itemView.findViewById(R.id.txt_country)
            txtCurrency = itemView.findViewById(R.id.txt_currency)
            txtCode = itemView.findViewById(R.id.txt_code)
            imageCheck = itemView.findViewById(R.id.image_check)


        }
    }

}