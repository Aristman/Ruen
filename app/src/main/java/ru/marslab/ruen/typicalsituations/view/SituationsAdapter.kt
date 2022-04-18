package ru.marslab.ruen.typicalsituations.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.databinding.RecyclerviewSituationsCardItemBinding
import ru.marslab.ruen.typicalsituations.model.Situation

class SituationsAdapter(
    private var onItemViewClickListener: OnItemViewClickListener?
) : RecyclerView.Adapter<SituationsAdapter.SituationsViewHolder>() {

    private var situationData: List<Situation> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setSituation(data: List<Situation>) {
        situationData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SituationsViewHolder {
        val binding = RecyclerviewSituationsCardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SituationsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SituationsViewHolder, position: Int) {
        holder.bind(situationData[position])
    }

    override fun getItemCount(): Int {
        return situationData.size
    }

    inner class SituationsViewHolder(private val binding: RecyclerviewSituationsCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(situation: Situation) {
            binding.apply {
                situationImage.setImageResource(situation.image)
                cardName.text = situation.name
                situationImage.setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(
                        situation
                    )
                }
                cardName.setOnClickListener { onItemViewClickListener?.onItemViewClick(situation) }
            }
        }
    }
}
