package ru.marslab.ruen.typicalsituations.view

import ru.marslab.ruen.typicalsituations.model.Situations

interface OnItemViewClickListener {
    fun onItemViewClick(situations: Situations)
}