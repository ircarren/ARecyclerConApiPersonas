package com.ircarren.arecyclerconapipersonas.provider

import com.ircarren.arecyclerconapipersonas.RecyclerDataClass

class RecyclerProvider() {
    companion object {
        public var listaDataClass: MutableList<RecyclerDataClass> = mutableListOf()

        fun addDataClass(dataClass: RecyclerDataClass) {
            listaDataClass.add(dataClass)

            
        }
    }
}