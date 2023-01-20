package com.example.lesson01_month05.presentation.view

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson01_month05.databinding.ItemNumberBinding
import com.example.lesson01_month05.domain.CardModel
import com.example.lesson01_month05.presentation.presenter.NGame


class AdapterN:RecyclerView.Adapter<AdapterN.ViewHolderN>() {
    private val numberGame = NGame()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderN {
   return ViewHolderN(ItemNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderN, position: Int) {
        holder.bind(numberGame.getCards()[position])
    }

    override fun getItemCount(): Int {
        return  numberGame.getCards().size
    }

    inner class ViewHolderN (private var binding: ItemNumberBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(card:CardModel<Int>) {
          if (card.isMatched) {
              onUiUpdate(card,true)
          } else {onUiUpdate(card,card.isFacedUp)}

            if (!card.isMatched){
            binding.frameItem.setOnClickListener{
               onUiUpdate(card,!card.isFacedUp)
                numberGame.onCardClick(card)
               Handler(Looper.getMainLooper()).postDelayed({
                    notifyDataSetChanged()
                },1000)}
            }

        }
       private fun onUiUpdate(card: CardModel<Int>,isFaced:Boolean){
            if (isFaced) {
                binding.tvItem.text = card.content.toString()
            } else { binding.tvItem.text = "" }
           binding.frameItem.isPressed = isFaced
        }

    }
}