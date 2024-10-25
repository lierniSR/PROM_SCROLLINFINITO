package com.example.webinars

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareasViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tcTask:TextView = view.findViewById(R.id.tvTask)
    private val ivTaskDone: ImageView = view.findViewById(R.id.ivTaskDone)

    fun render(task:String, onItemDone:(Int) -> Unit){
        tcTask.text = task
        ivTaskDone.setOnClickListener{
            onItemDone(adapterPosition)
        }
    }
}