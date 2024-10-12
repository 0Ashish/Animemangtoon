package com.example.animemangtoon


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animemangtoon.adapter.WebtoonAdapter
import com.example.animemangtoon.model.Webtoon
import com.example.animemangtoon.model.webToonList
import com.example.animemangtoon.screens.DetailActivity
import com.example.animemangtoon.screens.FavoritesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WebtoonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = WebtoonAdapter(webToonList) { webtoon ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("webtoon", webtoon)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter

//        favourite button
        findViewById<Button>(R.id.buttonFavorites).setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }
    }
}

