package ru.marslab.ruen.typicalsituations.view

import ru.marslab.ruen.typicalsituations.model.Situation

interface OnItemViewClickListener {
    fun onItemViewClick(situation: Situation)
}
