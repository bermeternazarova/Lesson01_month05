package com.example.lesson01_month05.domain

import android.os.Looper
import java.util.logging.Handler

class Game <gContent>(
    private val list: List<gContent>){
    private var cards:ArrayList<CardModel<gContent>> = ArrayList()

    init {
       list.forEachIndexed { index, cardContent ->
           cards.add(CardModel(id = index*index , content = cardContent))
           cards.add(CardModel(id = index*index+2, content = cardContent))
       }
    }
    fun getCards() = cards
    fun onCardClick(card :CardModel<gContent>) {
        card.isFacedUp = !card.isFacedUp
         cards.forEach{
             if (it.isFacedUp&&card.id!=it.id){
             if (card.content==it.content){
                 cards[cards.indexOf(card)].isFacedUp=true
                 it.isFacedUp= true
                 cards[cards.indexOf(card)].isMatched=true
                 it.isMatched= true
             }else if (!it.isMatched){
                 cards[cards.indexOf(card)].isFacedUp=false
                 it.isFacedUp= false
             }}
         }
    }
}