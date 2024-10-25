package com.example.webinars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks:List<String>): RecyclerView.Adapter<TareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TareasViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TareasViewHolder, position: Int) {
        holder.render(tasks[position])
    }

}