package com.ircarren.arecyclerconapipersonas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ircarren.arecyclerconapipersonas.R
import com.ircarren.arecyclerconapipersonas.RecyclerDataClass

class AdapterRecycler(var lista: List<RecyclerDataClass>) :
    RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    var item : List<RecyclerDataClass> = lista

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listas = item[position]
        holder.bind(listas)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombre = view.findViewById<TextView>(R.id.textView)
        val email = view.findViewById<TextView>(R.id.textView2)
        val avatar = view.findViewById<ImageView>(R.id.imageView)

        fun bind(listas: RecyclerDataClass) {
            nombre.text = listas.nombre
            email.text = listas.email
            Glide.with(itemView.context)
                .load(listas.avatar)
                .into(avatar)

        }
    }
}