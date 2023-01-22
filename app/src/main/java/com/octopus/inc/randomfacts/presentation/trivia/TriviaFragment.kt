package com.octopus.inc.randomfacts.presentation.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.octopus.inc.randomfacts.databinding.FragmentTriviaBinding

class TriviaFragment : Fragment() {

    private lateinit var binding: FragmentTriviaBinding
    private val viewModel: TriviaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTriviaBinding.inflate(inflater, container, false)

        viewModel.trivia.observe(viewLifecycleOwner) {
            binding.triviaTv.text = it
        }

        binding.getTriviaBtn.setOnClickListener {
            if (binding.numberEd.text.isNotEmpty()) {
                val number = binding.numberEd.text.toString().toInt()
                viewModel.getFact(number)
            }
        }

        return binding.root
    }
}