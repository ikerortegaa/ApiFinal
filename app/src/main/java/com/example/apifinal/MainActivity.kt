package com.example.apifinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apifinal.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SpaceXAdapter
    private val spaceXLaunches = mutableListOf<SpaceX>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        searchByName()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v5/launches/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName() {//Dejo el nombre de la función antigua aunque ya no se busca por nombre
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getSpaceXLaunch("past")
            val cohetes = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    val rockets : List<SpaceX> = cohetes ?: emptyList()
                    spaceXLaunches.clear()
                    spaceXLaunches.addAll(rockets)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = SpaceXAdapter(spaceXLaunches)
        binding.rvSpaceXLaunches.layoutManager = LinearLayoutManager(this)
        binding.rvSpaceXLaunches.adapter = adapter

        adapter.setOnItemClickListener(object : RecyclerViewInterface {
            override fun onClick(position: Int) {
                val intent = Intent(this@MainActivity, SpaceXDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("SPACE_X_LAUNCH", spaceXLaunches[position])
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}
