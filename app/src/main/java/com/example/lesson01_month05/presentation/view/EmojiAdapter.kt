package com.example.lesson01_month05.presentation.view

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson01_month05.databinding.ItemNumberBinding
import com.example.lesson01_month05.domain.CardModel
import com.example.lesson01_month05.presentation.presenter.EmojiGame
import com.example.lesson01_month05.presentation.presenter.NGame

class EmojiAdapter :RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {
    private val emojiGame = EmojiGame()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
       return EmojiViewHolder(ItemNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.bind(emojiGame.emojiCard()[position])
    }

    override fun getItemCount(): Int {
        return emojiGame.emojiCard().size
    }

    inner class EmojiViewHolder(private var binding: ItemNumberBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cardModel: CardModel<String>) {
            if (cardModel.isMatched) {
                onUiUpdate(cardModel,true)
            } else {onUiUpdate(cardModel,cardModel.isFacedUp)}

            if (!cardModel.isMatched){
                binding.frameItem.setOnClickListener{
                    onUiUpdate(cardModel,!cardModel.isFacedUp)
                    emojiGame.emojiCardClick(cardModel)
                    Handler(Looper.getMainLooper()).postDelayed({
                        notifyDataSetChanged()
                    },1000)}
            }
        }
        private fun onUiUpdate(cardModel: CardModel<String>,isFaced:Boolean){
            if (isFaced) {
                binding.tvItem.text = cardModel.content.toString()
            } else { binding.tvItem.text = "" }
            binding.frameItem.isPressed = isFaced
        }
    }
}