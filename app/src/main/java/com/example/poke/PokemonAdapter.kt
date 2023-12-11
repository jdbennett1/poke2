package com.example.poke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poke.data.Pokemon
import com.example.poke.databinding.RecycleItemBinding


class PokemonAdapter(private val onItemClicked: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            RecycleItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    class PokemonViewHolder(private var binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.apply {
                textname.text = pokemon.pokemonName
                textpower.text = pokemon.pokemonPower.toString()
                texttype.text = pokemon.pokemonType

            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.pokemonName == newItem.pokemonName
            }
        }
    }
}