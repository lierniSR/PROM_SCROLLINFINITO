package com.example.prueba

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * App para añadir tareas con 3 mejoras: Añadir reloj
 *
 * @author Lierni
 * @version 2.0
 */

class MainActivity : AppCompatActivity() {
    /**
     * Se inicializa después con el ID del xml
     */
    lateinit var textoEdit: EditText
    lateinit var buttonTareaAdd: Button
    lateinit var recyclerTareas: RecyclerView
    lateinit var adapter:AdapterTareas


    var tareas = mutableListOf<String>()



    /**
     * Crea la vista de la aplicacion
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textoEdit = findViewById(R.id.texto)
        initUi()
    }

    /**
     * Metodo para inicializar toda la logica de la app
     */
    private fun initUi() {
        initView();
        initListeners()
        initRecyclerView()
    }

    /**
     * Este metodo hara que el RecyclerView se muestre bien
     */
    private fun initRecyclerView() {
        recyclerTareas.layoutManager = LinearLayoutManager(this)
        adapter = AdapterTareas(tareas)
        recyclerTareas.adapter = adapter
    }

    /**
     * Metodo para crear los listener
     */
    private fun initListeners() {
        buttonTareaAdd.setOnClickListener{ aniadeTarea() }
    }

    /**
     * Metodo que llama el listener.
     * Lo añade a la lista para luego añadirlo a RecycledView
     * Para añadirlo se necesita un adapter y el viewHolder
     */
    private fun aniadeTarea() {
        val tareaAAniadir = textoEdit.text.toString()
        tareas.add(tareaAAniadir)
        adapter.notifyDataSetChanged()
        textoEdit.setText("")
    }

    /**
     * Metodo para crear la vista con los componentes
     */
    private fun initView() {
        buttonTareaAdd = findViewById(R.id.buttonTareaAdd)
        recyclerTareas = findViewById(R.id.recyclerTareas)
    }

    /**
     * Esta funcion llama a TimePicker de la clase de la propia aplicacion
     * Después abre la ventana para seleccionar la hora
     *
     * @param view
     */
    fun seleccionarHora(view: View) {
        val hora = TimePicker {hora, dia -> mostrarResultado(hora,dia)}
        hora.show(supportFragmentManager, "TimePicker")
    }

    /**
     * Esta funcion añade la hora a lo que el usuario introduce
     * La muestra despues en el textEdit
     *
     * @param hora
     * @param minuto
     */
    fun mostrarResultado(hora: Int, minuto: Int){
        var texto = textoEdit.text
        textoEdit.setText("$texto --> $hora:$minuto")
    }
}