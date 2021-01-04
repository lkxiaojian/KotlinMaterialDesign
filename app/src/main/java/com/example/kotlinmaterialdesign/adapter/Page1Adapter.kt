package com.example.kotlinmaterialdesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmaterialdesign.R


/**
 *create_time : 20-12-28 上午9:50
 *author: lk
 *description： Page1Adapter
 */
class Page1Adapter(_data: ArrayList<String>) :
    RecyclerView.Adapter<Page1Adapter.Page1ViewHolder>() {
    var list = _data


    inner class Page1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var atv: TextView = itemView.findViewById(R.id.atv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Page1ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.page1_item, parent, false)

        return Page1ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Page1ViewHolder, position: Int) {
        holder.atv.text = list[position]
    }

    override fun getItemCount() = if (list.isNullOrEmpty()) 0 else list.size
}