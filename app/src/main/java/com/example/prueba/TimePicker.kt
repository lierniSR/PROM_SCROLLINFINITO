package com.example.prueba

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePicker(val listener: (hora: Int, minuto:Int) -> Unit) : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onTimeSet(view: TimePicker?, horaDia: Int, minuto: Int) {
        listener(horaDia, minuto)
    }

    override fun onCreateDialog(saveInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hora = c.get(Calendar.HOUR_OF_DAY)
        val minuto = c.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this, hora, minuto, DateFormat.is24HourFormat(activity))
    }
}