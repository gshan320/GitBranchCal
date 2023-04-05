package com.example.gitbranchcal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gitbranchcal.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Numbers
        binding.button0.setOnClickListener { appendOnExpression("0", true) }
        binding.button1.setOnClickListener { appendOnExpression("1", true) }
        binding.button2.setOnClickListener { appendOnExpression("2", true) }
        binding.button3.setOnClickListener { appendOnExpression("3", true) }
        binding.button4.setOnClickListener { appendOnExpression("4", true) }
        binding.button5.setOnClickListener { appendOnExpression("5", true) }
        binding.button6.setOnClickListener { appendOnExpression("6", true) }
        binding.button7.setOnClickListener { appendOnExpression("7", true) }
        binding.button8.setOnClickListener { appendOnExpression("8", true) }
        binding.button9.setOnClickListener { appendOnExpression("9", true) }

        //Operators
        binding.buttonAddition.setOnClickListener { appendOnExpression("+", false) }
        binding.buttonSubtract.setOnClickListener { appendOnExpression("-", false) }
        binding.buttonMultiply.setOnClickListener { appendOnExpression("*", false) }
        binding.buttonDivision.setOnClickListener { appendOnExpression("/", false) }

        //Clear
        binding.buttonClear.setOnClickListener {
            binding.tvEquation.text = ""
            binding.tvAnswer.text = ""
        }

        //Equals
        binding.buttonEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.tvEquation.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()){
                    binding.tvAnswer.text = longResult.toString()
                }else {
                    binding.tvAnswer.text = result.toString()
                }

            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        addition()

    }

    private fun appendOnExpression(string: String, canClear: Boolean){
        if (canClear){
            binding.tvAnswer.text = ""
            binding.tvEquation.append(string)
        }else {
            binding.tvEquation.append(binding.tvAnswer.text)
            binding.tvEquation.append(string)
            binding.tvAnswer.text = ""
        }
    }

    private fun addition(){
        val integer = 10 * 10

        Log.i("addition", "test value: $integer")
    }

}