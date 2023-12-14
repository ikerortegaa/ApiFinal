package com.example.apifinal


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import com.example.apifinal.databinding.ActivitySpaceXDetailsBinding
import com.squareup.picasso.Picasso

class SpaceXDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpaceXDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpaceXDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spaceXLaunch = intent.getSerializableExtra("SPACE_X_LAUNCH") as SpaceX
        showSpaceXLaunchDetails(spaceXLaunch)

        binding.btnBackToMain.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showSpaceXLaunchDetails(spaceXLaunch: SpaceX) {
        // Mostrar los detalles del lanzamiento
        binding.tvLaunchName.text = spaceXLaunch.name ?: "Nombre no disponible"
        binding.tvLaunchDate.text = spaceXLaunch.dateUtc ?: "Fecha  no disponible"
        binding.tvLaunchWebcast.text = spaceXLaunch.links.webcast ?: "Webcast  no disponible"
        binding.tvLaunchFails.text = (spaceXLaunch.failures ?: "Fallos no disponibles").toString()
        binding.tvLaunchWikipedia.text = spaceXLaunch.links.wikipedia ?: "Wikipedia link  no disponible"

        val imageUrl = spaceXLaunch.links?.patch?.small
        Picasso.get().load(imageUrl).into(binding.ivSpaceXLaunch)

        // Hacer que los strings de los enlaces sean clicables
        makeLinksClickable()
    }

    private fun makeLinksClickable() {
        // Establezco el movimiento del enlace para los TextView
        binding.tvLaunchWebcast.movementMethod = LinkMovementMethod.getInstance()
        binding.tvLaunchWikipedia.movementMethod = LinkMovementMethod.getInstance()

        // Convierto los enlaces a hipervínculos clicables
        Linkify.addLinks(binding.tvLaunchWebcast, Linkify.WEB_URLS)
        Linkify.addLinks(binding.tvLaunchWikipedia, Linkify.WEB_URLS)
    }
}
