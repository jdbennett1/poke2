package com.example.poke.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: Pokemon)
    @Delete
    suspend fun delete(pokemon: Pokemon)
    @Query("SELECT * from poketable ORDER BY name ASC")
    fun getPokemon(): Flow<List<Pokemon>>


}