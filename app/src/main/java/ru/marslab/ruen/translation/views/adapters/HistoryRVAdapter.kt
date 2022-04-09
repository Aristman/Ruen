package ru.marslab.ruen.translation.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.databinding.ItemHistoryBinding
import ru.marslab.ruen.translation.beans.Word
import javax.inject.Inject


class HistoryRVAdapter @Inject constructor(private var wordsList: List<Word> = mutableListOf()) :
    RecyclerView.Adapter<HistoryRVAdapter.ViewHolder>() {

    fun updateWordsList(list: List<Word>) {
        wordsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.set(wordsList[position])
    }

    override fun getItemCount() = wordsList.size

    class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun set(wordEntity: Word) = with(binding) {
            word.text = wordEntity.value
            translateWord.text = wordEntity.translation
        }
    }
}