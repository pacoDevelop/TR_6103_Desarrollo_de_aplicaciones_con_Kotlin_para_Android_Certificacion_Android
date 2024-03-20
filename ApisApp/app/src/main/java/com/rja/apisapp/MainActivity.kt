package com.rja.apisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.rja.apisapp.api.TheCatApiService
import com.rja.apisapp.model.ImageResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val breed_name: TextView by lazy { findViewById(R.id.breed_name) }
    private val breed_temperament: TextView by lazy { findViewById(R.id.breed_temperament) }
    private val breed_image: ImageView by lazy { findViewById(R.id.breed_image) }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val theCatApiService by lazy {
        retrofit.create(TheCatApiService::class.java)
    }

    private val imageLoader by lazy { GlideImageLoader(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCatImageResponse()
    }

    private fun getCatImageResponse() {
        val call = theCatApiService.searchImages(1 ,"full")
        call.enqueue(object : Callback<List<ImageResultData>>{
            override fun onFailure(call: Call<List<ImageResultData>>, t: Throwable) {
                Log.e("MainActivity", "Fallo en la obtencion de datos")
            }

            override fun onResponse(
                call: Call<List<ImageResultData>>,
                response: Response<List<ImageResultData>>
            ) {
                if (response.isSuccessful) {
                    val imageResults = response.body()
                    val firstImageUrl = imageResults?.firstOrNull()?.imageUrl ?: ""
                    if (firstImageUrl.isNotBlank()) {
                        imageLoader.loadImage(firstImageUrl, breed_image)
                    } else {
                        Log.d("MainActivity", "Missing image URL")
                    }
                    breed_name.text =
                        imageResults?.firstOrNull()?.breeds?.firstOrNull()?.name ?: "Sin data"
                    breed_temperament.text =
                        imageResults?.firstOrNull()?.breeds?.firstOrNull()?.temperament ?: "Sin data"
                } else {
                    Log.e("MainActivity", "Error:${response.errorBody()?.string() ?: ""}")
                }
            }
        }
        )
    }
}