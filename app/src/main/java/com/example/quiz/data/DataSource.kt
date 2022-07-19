package com.example.quiz.data

import com.example.quiz.data.model.Vip

class DataSource  {

  fun loadVips(): List<Vip> {

    val vipList = listOf(
      Vip("Andrea Bocelli", true),
      Vip("Nena", true),
      Vip("Madonna", true),
      Vip("Depeche Mode", true),
      Vip("Simple Minds", true),
      Vip("Reinhardt May", true),
      Vip("Gazebo", true),
      Vip("Heino", true),
      Vip("Steffi Graf", false),
      Vip("Mario Basler", false),
      Vip("Boris Becker", false),
      Vip("Rudi Völler", false),
      Vip("Franz Beckenbauer", false),
      Vip("Gerd Müller", false),
      Vip("Bastian Schweinsteiger", false),
      Vip("Karl Heinz Riedle", false)
    )

    return vipList.shuffled()

  }
}