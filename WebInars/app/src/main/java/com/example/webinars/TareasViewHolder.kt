package com.example.webinars

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareasViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tcTask:TextView = view.findViewById(R.id.tvTask)

    fun render(task:String){
        tcTask.text = task
    }
}