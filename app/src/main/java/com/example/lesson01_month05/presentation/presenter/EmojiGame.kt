package com.example.lesson01_month05.presentation.presenter

import com.example.lesson01_month05.domain.CardModel
import com.example.lesson01_month05.domain.Game
import java.util.jar.Attributes.Name

class EmojiGame {
    private val emojiGame= Game (listOf("\uD83D\uDE01","\uD83E\uDD17","\uD83E\uDEE0","\uD83D\uDE07","\uD83E\uDD76","\uD83E\uDD22").shuffled())
    fun emojiCard()=emojiGame.getCards()
    fun emojiCardClick(cardModel: CardModel<String>){
        emojiGame.onCardClick(cardModel)
    }
}