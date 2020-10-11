package com.example.binarycheckerapp

import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val switchList = listOf<Switch>(
            switch0, switch1, switch2, switch3,
            switch4, switch5, switch6, switch7
        )
        var checkList = mutableListOf(false, false, false, false, false, false, false, false)

        fun updateNumber() {
            var totalValue: UInt = 0u
            val one: UInt = 1u

            for (n in 0..7) {
                if (checkList[n])
                    totalValue = totalValue or one.shl(n)
            }

            textView.text = "$totalValue\n${totalValue.toString(2).padStart(8, '0')}"

            if (totalValue.toString() == editTextNumber2.text.toString())
                textView.setBackgroundColor(BLUE)
            else
                textView.setBackgroundColor(TRANSPARENT)
        }

        editTextNumber2.setOnEditorActionListener { v, actionId, event ->
            updateNumber()
            true
        }

        for (n in 0..7) {
            switchList[n].setOnCheckedChangeListener { buttonView, isChecked ->
                checkList[n] = isChecked
                updateNumber()
            }
        }
    }
}