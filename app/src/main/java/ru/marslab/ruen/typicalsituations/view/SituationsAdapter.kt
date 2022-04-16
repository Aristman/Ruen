package ru.marslab.ruen.typicalsituations.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.databinding.RecyclerviewSituationsCardItemBinding
import ru.marslab.ruen.typicalsituations.model.Situations

class SituationsAdapter(
    private var onItemViewClickListener: OnItemViewClickListener?
) : RecyclerView.Adapter<SituationsAdapter.SituationsViewHolder>() {

    private var situationsData: List<Situations> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setSituation(data: List<Situations>) {
        situationsData = data
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
        holder.bind(situationsData[position])
    }

    override fun getItemCount(): Int {
        return situationsData.size
    }

    inner class SituationsViewHolder(private val binding: RecyclerviewSituationsCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(situation: Situations) {
            binding.apply {
                situationImage.setImageResource(situation.situationImage)
                cardName.text = situation.situationName
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
