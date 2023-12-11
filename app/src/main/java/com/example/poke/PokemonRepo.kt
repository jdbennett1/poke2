package com.example.poke

import android.app.Application
import com.example.poke.data.PokemonRoomDatabase

class PokemonRepo :Application() {
    val database: PokemonRoomDatabase by lazy { PokemonRoomDatabase.getDatabase(this) }


}