package ru.marslab.ruen.typicalsituations.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.marslab.ruen.R
import ru.marslab.ruen.databinding.RecyclerviewSituationsCardItemBinding
import ru.marslab.ruen.typicalsituations.model.Situations

class SituationsAdapter(
    private var situationsData: List<Situations>,
    private var onItemViewClickListener: OnItemViewClickListener?
) : RecyclerView.Adapter<SituationsAdapter.SituationsViewHolder>() {

    private val colors = listOf(PURPLE_COLOR, BLUE_COLOR, YELLOW_COLOR, GREEN_COLOR)

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
        val cardView: CardView = holder.itemView.findViewById(R.id.cardView)
        holder.bind(situationsData[position])
        cardView.setCardBackgroundColor(Color.parseColor(colors[position % colors.size]))
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

    companion object {
        const val PURPLE_COLOR = "#7109AA"
        const val BLUE_COLOR = "#1240AB"
        const val YELLOW_COLOR = "#FFD300"
        const val GREEN_COLOR = "#228653"
    }
}