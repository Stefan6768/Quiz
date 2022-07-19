package com.example.quiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quiz.databinding.FragmentErgebnisBinding

class ErgebnisFragment : Fragment(){

  private lateinit var binding: FragmentErgebnisBinding

  private var score = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    arguments?.let {
      score = it.getInt("score")
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentErgebnisBinding.inflate(layoutInflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.ergebnisScoreText.text = "Du hast $score Fragen richtig beantwortet"
  }
}