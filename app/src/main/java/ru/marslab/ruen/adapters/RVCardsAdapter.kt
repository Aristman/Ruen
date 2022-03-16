package ru.marslab.ruen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.Card
import ru.marslab.ruen.databinding.RvCardItemBinding

class RVCardsAdapter : RecyclerView.Adapter<RVCardsAdapter.ViewHolder>() {

    private val cardsList = mutableListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            RvCardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(cardsList[position].value)
    }

    override fun getItemCount() = cardsList.size

    fun updateCards(cards: List<Card>) {
        cardsList.apply {
            clear()
            addAll(cards)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: RvCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setText(text: String) {
            binding.tvWord.text = text
        }
    }
}