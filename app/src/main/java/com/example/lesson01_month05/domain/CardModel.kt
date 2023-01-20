package com.example.lesson01_month05.domain

data class CardModel<Content>(
    var isFacedUp:Boolean= false,
    var isMatched:Boolean = false,
    var id :Int,
    var content:Content
)
