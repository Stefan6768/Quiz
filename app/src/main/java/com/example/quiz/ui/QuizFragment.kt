package com.example.quiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quiz.data.DataSource
import com.example.quiz.data.model.Vip
import com.example.quiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment(){

  private lateinit var binding: FragmentQuizBinding

  private var score = 0

  private lateinit var currentVip: Vip

  private val vipList = DataSource().loadVips()

  private var index = 0

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = FragmentQuizBinding.inflate(layoutInflater)

    return  binding.root

  }

  override fun  onViewCreated(view: View, savedInstanceState: Bundle?) {

    currentVip = vipList[index]

    binding.scoreText.text = score.toString()
    binding.questionText.text = currentVip.name

    binding.musikerButton.setOnClickListener {
      checkAnswerUpdate(true)
    }

    binding.sportlerButton.setOnClickListener {
      checkAnswerUpdate(false)
    }
  }

  private fun checkAnswerUpdate(clickedAnswer: Boolean) {

    if (clickedAnswer == currentVip.isMusiker) {
      score ++
  }

  if (index < vipList.size -1) {
    index ++
  } else {
    findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToErgebnisFragment2(score))
  }
    currentVip = vipList[index]

    binding.questionText.text = currentVip.name
    binding.scoreText.text = score.toString()

  }
}