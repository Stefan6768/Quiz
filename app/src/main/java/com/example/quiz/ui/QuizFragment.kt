package com.example.quiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentQuizBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuizFragment : Fragment(){

  private lateinit var binding: FragmentQuizBinding

  private val viewModel: QuizViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = FragmentQuizBinding.inflate(layoutInflater)

    return  binding.root

  }

  override fun  onViewCreated(view: View, savedInstanceState: Bundle?) {

    binding.scoreText.text = viewModel.score.toString()

    binding.questionText.text = viewModel.currentVip.name

    binding.musikerButton.setOnClickListener {
      viewModel.checkAnswer(true)

      if (viewModel.finished) {
        showEndDialog()
      }

      binding.questionText.text = viewModel.currentVip.name
      binding.scoreText.text = viewModel.score.toString()
    }

    binding.sportlerButton.setOnClickListener {
      viewModel.checkAnswer(false)

      if (viewModel.finished) {
        showEndDialog()
      }

      binding.questionText.text = viewModel.currentVip.name
      binding.scoreText.text = viewModel.score.toString()

    }
  }

  private  fun showEndDialog() {
    MaterialAlertDialogBuilder(requireContext())
      .setTitle("Gut geraten!")
      .setMessage("Du hast ${viewModel.score} mal richtig beantwortet")
      .setCancelable(false)
      .setNegativeButton("verlassen") { _, _ ->
        exitQuiz()
      }
      .setPositiveButton("spiele nochmal") { _, _ ->
        restartQiuz()
      }
      .show()
  }

  private fun exitQuiz() {
    activity?.finish()
  }

  private fun  restartQiuz() {
    viewModel.restartGame()
    binding.scoreText.text = viewModel.score.toString()
    binding.questionText.text = viewModel.currentVip.name
  }
}