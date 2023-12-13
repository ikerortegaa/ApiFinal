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
        binding.tvLaunchName.text = spaceXLaunch.name ?: "Name not available"
        binding.tvLaunchDate.text = spaceXLaunch.dateUtc ?: "Date not available"
        binding.tvLaunchWebcast.text = spaceXLaunch.links.webcast ?: "Webcast not available"
        binding.tvLaunchYouTube.text = spaceXLaunch.links.youtubeId ?: "YouTube not available"
        binding.tvLaunchWikipedia.text = spaceXLaunch.links.wikipedia ?: "Wikipedia link not available"

        val imageUrl = spaceXLaunch.links?.patch?.small
        Picasso.get().load(imageUrl).into(binding.ivSpaceXLaunch)

        // Hacer que los strings de los enlaces sean clicables
        makeLinksClickable()
    }

    private fun makeLinksClickable() {
        // Establezco el movimiento del enlace para los TextView
        binding.tvLaunchWebcast.movementMethod = LinkMovementMethod.getInstance()
        binding.tvLaunchYouTube.movementMethod = LinkMovementMethod.getInstance()
        binding.tvLaunchWikipedia.movementMethod = LinkMovementMethod.getInstance()

        // Convierto los enlaces a hipervínculos clicables
        Linkify.addLinks(binding.tvLaunchWebcast, Linkify.WEB_URLS)
        Linkify.addLinks(binding.tvLaunchYouTube, Linkify.WEB_URLS)
        Linkify.addLinks(binding.tvLaunchWikipedia, Linkify.WEB_URLS)
    }
}
