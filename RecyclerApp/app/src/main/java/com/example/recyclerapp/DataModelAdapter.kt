package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataModelAdapter(private val dataList: MutableList<DataModel>) :
    RecyclerView.Adapter<DataModelAdapter.DataModelViewHolder>() {

    // ViewHolder class that represents each item in the RecyclerView
    class DataModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val uuidTextView: TextView = itemView.findViewById(R.id.uuidTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_view_holder, parent, false)
        return DataModelViewHolder(view)
    }

    // Binds data to the ViewHolder
    override fun onBindViewHolder(holder: DataModelViewHolder, position: Int) {
        val data = dataList[position]
        holder.nameTextView.text = data.name
        holder.uuidTextView.text = data.uuid.toString()  // Converts UUID to String
        holder.descriptionTextView.text = data.desc  // Matches the field name in DataModel.kt
    }

    // Returns the total number of items
    override fun getItemCount(): Int {
        return dataList.size
    }
}
