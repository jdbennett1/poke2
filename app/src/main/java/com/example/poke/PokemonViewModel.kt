package com.example.poke

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.poke.data.Pokemon
import com.example.poke.data.PokemonDao
import kotlinx.coroutines.launch

class PokemonViewModel ( private val pokemonDao: PokemonDao) : ViewModel(){
    val allPokemon : LiveData<List<Pokemon>> = pokemonDao.getPokemon().asLiveData()


    private fun insertPokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemonDao.insert(pokemon)
        }
    }
    fun deletePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemonDao.delete(pokemon)
        }
    }
    fun isEntryValid(pokemonName: String, pokemonPower: String, pokemonAtt: String): Boolean {
        if (pokemonName.isBlank() || pokemonPower.isBlank() || pokemonPower.isBlank()) {
            return false
        }
        return true
    }
}

class PokemonViewModelFactory(private val pokemonDao: PokemonDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PokemonViewModel(pokemonDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}