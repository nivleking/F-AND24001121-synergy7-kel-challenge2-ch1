package com.binar.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var costOfService: TextInputEditText = findViewById(R.id.costOfService)
        val checkedRadio: RadioGroup = findViewById(R.id.radioGroup)

        var currentTotal: TextView = findViewById(R.id.currentTotal)
        val switchButton: MaterialSwitch = findViewById(R.id.roundUpSwitch)
        val calButton: Button = findViewById(R.id.elevatedButton)

        calButton.setOnClickListener {
            val cost = costOfService.text.toString().toDouble()
            val total = when (checkedRadio.checkedRadioButtonId) {
                R.id.radio_button_1 -> {
                    cost + (cost * 0.20)
                }

                R.id.radio_button_2 -> {
                    cost + (cost * 0.18)
                }

                R.id.radio_button_3 -> {
                    cost + (cost * 0.15)
                }

                else -> cost
            }
            if (!switchButton.isChecked) {
                currentTotal.text = "Total: Rp$total"
            } else {
                currentTotal.text = "Total: Rp${total.toInt()}"
            }
        }
    }
}