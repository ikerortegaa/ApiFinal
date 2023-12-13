package com.example.apifinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SpaceXAdapter(private val launches: List<SpaceX>) : RecyclerView.Adapter<SpaceXViewHolder>() {

    private lateinit var listener: RecyclerViewInterface // Listener para los clics

    // Método para establecer el listener desde fuera del adaptador
    fun setOnItemClickListener(listener: RecyclerViewInterface) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SpaceXViewHolder(layoutInflater.inflate(R.layout.item_space_x_launch, parent, false))
    }

    override fun getItemCount(): Int = launches.size

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        val item = launches[position]
        holder.bind(item)

        // Configuro el clic y establezco el listener
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }
}
