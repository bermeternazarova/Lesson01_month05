package com.example.lesson01_month05.presentation.presenter

import com.example.lesson01_month05.domain.CardModel
import com.example.lesson01_month05.domain.Game

class NGame {
    private val game= Game (listOf(1,2,3,4,5,6).shuffled())
    fun getCards()= game.getCards()
    fun onCardClick(card:CardModel<Int>){
        game.onCardClick(card)
    }
}