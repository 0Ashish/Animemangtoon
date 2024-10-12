package com.example.animemangtoon.screens

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.animemangtoon.R
import com.example.animemangtoon.database.AppDatabase
import com.example.animemangtoon.model.Favorite
import com.example.animemangtoon.model.Webtoon
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Initialize the database
        database = AppDatabase.getDatabase(this)

        // Retrieve the Webtoon object from the intent
        val webtoon = intent.getParcelableExtra<Webtoon>("webtoon")

        // Initialize views
        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        val buttonAddToFavorites = findViewById<Button>(R.id.buttonAddToFavorites)

        // Check if the webtoon object is not null
        webtoon?.let {
            // Set data to the views
            detailTitle.text = it.title
            detailDescription.text = it.description
            Glide.with(this).load(it.imageUrl).into(detailImage)

//             Handle adding to favorites
            buttonAddToFavorites.setOnClickListener {
                webtoon?.let { webtoon ->
                    if (webtoon.title.isNotEmpty() && webtoon.imageUrl.isNotEmpty() && webtoon.description.isNotEmpty()) {
                        val favorite = Favorite(webtoon.title, webtoon.imageUrl, webtoon.description)
                        lifecycleScope.launch {
                            // Insert the webtoon into the favorites table
                            database.favoriteDao().insert(favorite)

                            // Show a Toast after the item is added to favorites
                            runOnUiThread {
                                Toast.makeText(this@DetailActivity, "${webtoon.title} added to favorites", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Invalid webtoon data!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        } ?: run {
            // Handle the case where webtoon is null (e.g., show a toast or log)
            detailTitle.text = "No data available"
        }
    }
}
