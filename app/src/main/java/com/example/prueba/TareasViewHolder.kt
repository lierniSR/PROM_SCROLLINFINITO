package com.example.prueba

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Layout o estilo del recyclerView
 *
 * @param view
 * @author Lierni
 * @version 2.0
 */
class TareasViewHolder(view : View): RecyclerView.ViewHolder(view) {

    private val textViewTarea:TextView = view.findViewById(R.id.textViewTarea)

    /**
     * Se encarga de isnertar en el textview el texto que le llega como parametro
     *
     * @param tarea
     */
    fun insertarTarea(tarea:String){
        textViewTarea.text = tarea
    }

}