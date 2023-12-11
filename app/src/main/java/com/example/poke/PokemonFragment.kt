package com.example.poke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poke.databinding.FragmentPokemonBinding



class PokemonFragment : Fragment() {
    private val viewModel: PokemonViewModel by activityViewModels {
        PokemonViewModelFactory(
            (activity?.application as PokemonRepo).database.pokemonDao()
        )
    }
    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PokemonAdapter {
            val action = PokemonFragmentDirections.actionPokemonFragmentToPokemonInfoFragment()
            this.findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter
        viewModel.allPokemon.observe(this.viewLifecycleOwner) { items ->
            items.let {
                adapter.submitList(it)
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.floatingActionButton.setOnClickListener {
            val action = PokemonFragmentDirections.actionPokemonFragmentToPokemonInfoFragment()
            this.findNavController().navigate(action)
        }
    }
}