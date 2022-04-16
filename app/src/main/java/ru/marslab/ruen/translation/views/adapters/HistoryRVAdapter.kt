package ru.marslab.ruen.translation.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.databinding.ItemHistoryBinding
import ru.marslab.ruen.translation.beans.Word
import javax.inject.Inject

class HistoryRVAdapter @Inject constructor() :
    RecyclerView.Adapter<HistoryRVAdapter.ViewHolder>() {
    private var wordsList: List<Word> = mutableListOf()
    private var onClickListener: ((word: String) -> Unit)? = null

    fun setClickListener(listener: ((word: String) -> Unit)) {
        onClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateWordsList(list: List<Word>) {
        wordsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ).apply { setOnClickListener() }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = wordsList[position]
        holder.set(word)
    }

    override fun getItemCount() = wordsList.size

    inner class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var innerWord: Word? = null
        fun set(wordEntity: Word) = with(binding) {
            innerWord = wordEntity
            firstWord.text = wordEntity.value
            secondWord.text = wordEntity.translation
        }

        fun setOnClickListener() = with(binding) {
            itemHistory.setOnClickListener {
                if (innerWord != null) {
                    this@HistoryRVAdapter.onClickListener?.invoke(innerWord!!.value)
                }
            }
        }
    }
}
