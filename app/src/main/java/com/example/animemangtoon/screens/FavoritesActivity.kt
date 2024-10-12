package com.example.animemangtoon.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animemangtoon.R
import com.example.animemangtoon.adapter.WebtoonAdapter
import com.example.animemangtoon.database.AppDatabase
import com.example.animemangtoon.model.Favorite
import com.example.animemangtoon.model.Webtoon
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class FavoritesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WebtoonAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        recyclerView = findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(this)
        database = AppDatabase.getDatabase(this)

        lifecycleScope.launch {
            val favorites: List<Favorite> = database.favoriteDao().getAllFavorites()
            val webtoons = favorites.map { Webtoon(it.title, it.imageUrl, it.description) }
            adapter = WebtoonAdapter(webtoons) { webtoon ->
                // Handle clicks on favorite items if needed
            }
            recyclerView.adapter = adapter
        }

        //    clearing favorites
        val onItemTouchHelperCallback = object:ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val webtoon = adapter.getItemAtPosition(position)

                val favorite = Favorite(webtoon.title, webtoon.imageUrl, webtoon.description)

//                remove item on swipe
                lifecycleScope.launch {
                    database.favoriteDao().delete(favorite)
                    Snackbar.make(recyclerView ,"Item deleted",Snackbar.LENGTH_LONG).show()
                }
            }
        }
        ItemTouchHelper(onItemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }
}
