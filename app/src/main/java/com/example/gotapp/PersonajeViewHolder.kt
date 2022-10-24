package com.example.gotapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class PersonajeViewHolder (view: View) :RecyclerView.ViewHolder(view) {
     val personaje = view.findViewById<ImageView>(R.id.item_image)

    fun bind(image:String){
        Picasso.get().load(image).into(personaje)
    }
}


