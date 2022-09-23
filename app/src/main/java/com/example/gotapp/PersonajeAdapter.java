package com.example.gotapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    List<Personaje> personajes;

    public PersonajeAdapter(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemPersonaje = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personaje, parent, false);
        return new PersonajeViewHolder(itemPersonaje);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        holder.itemImage.setImageURI(personajes.get(position).getImagen());
        holder.tvNombre.setText(personajes.get(position).getNombre());
        holder.tvGenero.setText(personajes.get(position).getGenero());
        holder.tvNacimiento.setText(personajes.get(position).getNacimiento());
        holder.tvCultura.setText(personajes.get(position).getCultura());
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView tvNombre;
        TextView tvGenero;
        TextView tvNacimiento;
        TextView tvCultura;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            tvNombre = itemView.findViewById(R.id.tv_nombre_full);
            tvGenero = itemView.findViewById(R.id.tv_genero);
            tvNacimiento = itemView.findViewById(R.id.tv_nacimiento);
            tvCultura = itemView.findViewById(R.id.tv_cultura);
        }
    }
}
