package ru.marslab.ruen.settingsscreen.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import ru.marslab.ruen.R

class ToggleableSetting(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val textView: TextView
    private val switch: SwitchCompat

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.ToggleableSetting, 0, 0
        )
        val text = a.getString(R.styleable.ToggleableSetting_text)
        val switchState = a.getBoolean(R.styleable.ToggleableSetting_checked, false)
        a.recycle()
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.toggleable_setting, this)
        textView = getChildAt(0) as TextView
        textView.text = text
        switch = getChildAt(1) as SwitchCompat
        switch.isChecked = switchState
    }

    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener) {
        switch.setOnCheckedChangeListener(listener)
    }

    fun setChecked(value: Boolean) {
        switch.isChecked = value
    }

    fun isChecked() = switch.isChecked

    fun setText(text: String) {
        textView.text = text
    }

    fun getText() = textView.text
}
