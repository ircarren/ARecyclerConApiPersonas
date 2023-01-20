package com.ircarren.arecyclerconapipersonas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ircarren.arecyclerconapipersonas.adapter.AdapterRecycler
import com.ircarren.arecyclerconapipersonas.api.APersonaClient
import com.ircarren.arecyclerconapipersonas.databinding.ActivityMainBinding
import com.ircarren.arecyclerconapipersonas.provider.RecyclerProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

//REcycler segun https://www.youtube.com/watch?v=hGrS3SmWvQI&t=3675s y correcion de YanPierre

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var personasAdapter = AdapterRecycler(emptyList())
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = AdapterRecycler(RecyclerProvider.listaDataClass)
        //personasAdapter.notifyDataSetChanged()

        lifecycleScope.launch {
            val listadoPersonas = APersonaClient.service.listPersonas()
            //ESTA PARTE SE TIENE QUE EJECUTAR CON CORROUTINAS PQ ES CUANDO PREGUNTA AL SERVIDOR
            val body = withContext(Dispatchers.IO) {listadoPersonas.execute().body()}
            if (body != null) {
                Log.d("MainActivity", "PERSONACOUNT: $body.results.size.toString()")
                var listapersona = ArrayList<RecyclerDataClass>()
                for (persona in body.results) {
                    var auxpersona = RecyclerDataClass(
                        persona.name.first,
                        persona.email,
                        persona.picture.large,
                        persona.dob.age
                    )
                    listapersona.add(auxpersona)
                }
                initpersonas(listapersona)
            }
        }
    }

    fun initpersonas(datos: ArrayList<RecyclerDataClass>) {
        RecyclerProvider.listaDataClass.clear()
        RecyclerProvider.listaDataClass.addAll(datos)
        binding.recycler.adapter?.notifyDataSetChanged()
    }
}