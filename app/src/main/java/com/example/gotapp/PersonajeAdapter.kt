package com.example.gotapp


import androidx.recyclerview.widget.RecyclerView
import com.example.gotapp.PersonajeAdapter.PersonajeViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.gotapp.R
import android.widget.TextView

class PersonajeAdapter(var personajes: MutableList<String>) : RecyclerView.Adapter<PersonajeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val itemPersonaje =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_personaje, parent, false)
        return PersonajeViewHolder(itemPersonaje)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {

        holder.itemImage.setImageURI(personajes[position].imagen)
        holder.tvNombre.text = personajes[position].nombre
        holder.tvGenero.text = personajes[position].genero
        holder.tvNacimiento.text = personajes[position].nacimiento
        holder.tvCultura.text = personajes[position].cultura
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    inner class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var tvNombre: TextView
        var tvGenero: TextView
        var tvNacimiento: TextView
        var tvCultura: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            tvNombre = itemView.findViewById(R.id.tv_nombre_full)
            tvGenero = itemView.findViewById(R.id.tv_genero)
            tvNacimiento = itemView.findViewById(R.id.tv_nacimiento)
            tvCultura = itemView.findViewById(R.id.tv_cultura)
        }
    }
}