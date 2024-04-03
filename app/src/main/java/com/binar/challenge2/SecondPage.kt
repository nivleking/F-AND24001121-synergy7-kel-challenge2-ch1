package com.binar.challenge2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.binar.challenge2.Model.Tip
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val BackButton: ImageView = findViewById(R.id.backButton)
        BackButton.setOnClickListener {
            finish()
        }

        val totalTip: MaterialTextView = findViewById(R.id.totalTip)
        val bundle = intent.extras
        val tip = bundle?.getParcelable<Tip>("tip")

        val temp = tip?.price?.minus(tip.tip)
        totalTip.text = "Total harga: Rp${tip?.price}-${tip?.tip}\nRp$temp\nTerima kasih"

        val openWA: MaterialButton = findViewById(R.id.openWhatsApp)
        openWA.setOnClickListener {
            val i = Intent().apply {
                val message = "Total harga = Rp${tip?.tip}"
                val url = "https://wa.me/6281234567890?text=$message"
                action = Intent.ACTION_VIEW
                data = android.net.Uri.parse(url)
            }
            startActivity(i)
        }
    }
}