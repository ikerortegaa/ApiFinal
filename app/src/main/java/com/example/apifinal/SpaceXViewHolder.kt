package com.example.apifinal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apifinal.databinding.ItemSpaceXLaunchBinding
import com.squareup.picasso.Picasso

class SpaceXViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSpaceXLaunchBinding.bind(view)

    fun bind(spaceXLaunch: SpaceX) {
        // Hago el binding de los datos del lanzamiento de SpaceX a tu diseño de vista
        binding.tvLaunchName.text = spaceXLaunch.name ?: "Nombre no disponible"

        // Carga de imágenes si aplicable
        val imageUrl = spaceXLaunch.links?.patch?.small
        Picasso.get().load(imageUrl).into(binding.ivSpaceXLaunch)
    }
}
