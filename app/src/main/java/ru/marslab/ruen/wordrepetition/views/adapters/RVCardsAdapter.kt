package ru.marslab.ruen.wordrepetition.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.databinding.ItemHistoryBinding
import ru.marslab.ruen.wordrepetition.domain.Card
import javax.inject.Inject

class RVCardsAdapter @Inject constructor() : RecyclerView.Adapter<RVCardsAdapter.ViewHolder>() {

    private val cardsList = mutableListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(cardsList[position].value)
    }

    override fun getItemCount() = cardsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateCards(cards: List<Card>) {
        cardsList.apply {
            clear()
            addAll(cards)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun setText(text: String) {
            with(binding) {
                firstWord.text = text
                secondWord.text = "[$text]"
            }
        }
    }
}
