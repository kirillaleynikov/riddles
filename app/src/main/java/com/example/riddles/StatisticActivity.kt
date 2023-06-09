package com.example.riddles
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.riddles.databinding.ActivityStatisticBinding

class StatisticActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatisticBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val trueCounter = intent.getStringExtra("trueCount")
        val falseCounter = intent.getStringExtra("falseCount")
        val allCounter = intent.getStringExtra("allCount")
        binding.tvTrueCount.text = trueCounter.toString()
        binding.tvFalseCount.text = falseCounter.toString()
        binding.textView5.text = allCounter.toString()

        binding.btnGoBack.setOnClickListener{
            finish()
        }
    }
}