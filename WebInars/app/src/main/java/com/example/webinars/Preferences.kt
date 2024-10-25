package com.example.webinars

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    //Para poner constantes
    companion object{
        //En mayuscula para que se lea mejor en el codigo, se suele utilizar en constantes
        const val PREFS_NAME = "myDataBase"
        const val TASK = "task_value"
    }


    val prefs:SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    //Si no se llama a apply no se actualiza
    fun saveTasks(task:List<String>){
        prefs.edit().putStringSet(TASK, task.toSet()).apply()
    }

    fun getTasks():MutableList<String>{
        //!! parar decirle que no va a ser numero
        return prefs.getStringSet(TASK, emptySet<String>())!!.toMutableList()
    }
}