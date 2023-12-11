package com.example.poke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.poke.databinding.FragmentPokemonInfoBinding

class PokemonInfoFragment : Fragment() {
    private val viewModel: PokemonViewModel by activityViewModels {
        PokemonViewModelFactory(
            (activity?.application as PokemonRepo).database.pokemonDao()
        )
    }
    private var _binding: FragmentPokemonInfoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

}