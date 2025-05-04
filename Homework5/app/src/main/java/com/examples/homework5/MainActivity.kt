package com.examples.homework5

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.examples.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private var firstNum = 0
    private var secondNum = 0
    private var numList = ArrayList<Int>()
    private var opList = ArrayList<Button>()
    private var newNum = 0
    private var result = 0
    var operation : Button? = null
    var operationCounter = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setUpNumbers()
        setUpOperations()
        setUpOtherButtons()

        setContentView(binding.root)

    }

    private fun setUpNumbers()
    {
        val numberButtons = listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9
        )

        for(i in numberButtons.indices)
        {
            numberButtons[i].setOnClickListener {
                onNumberClick(i.toString())
            }
        }
    }

    private fun onNumberClick(i:String)
    {
        val currentText = binding.resultText.text.toString()

        if(currentText == "0")
        {
            binding.resultText.text = i
            newNum = i.toInt()
        }
        else
        {
            binding.resultText.text = currentText + i
            newNum = (newNum.toString() + i.toString()).toInt()
        }

    }

    private fun setUpOperations()
    {
        val operations = listOf(
            binding.buttonSummation,
            binding.buttonSubstraction,
            binding.buttonMultiplacation,
            binding.buttonDivision
        )

        for (i in operations.indices)
        {
            operations[i].setOnClickListener {
                puttingOperation(operations[i])
            }
        }

    }

    private fun puttingOperation(operationSelected: Button)
    {
        numList.add(newNum)
        newNum = 0
        when(operationSelected)
        {
            binding.buttonSummation -> binding.resultText.text = binding.resultText.text.toString() + "+"
            binding.buttonSubstraction -> binding.resultText.text = binding.resultText.text.toString() + "-"
            binding.buttonMultiplacation -> binding.resultText.text = binding.resultText.text.toString() + "*"
            binding.buttonDivision -> binding.resultText.text = binding.resultText.text.toString() + "/"
        }
        opList.add(operationSelected)
    }

    private fun makingCalculation()
    {
        lateinit var currentOperation: Button
        var i = 1
        var indexOfOp = 0
        firstNum = numList[0]

        do {
            secondNum = numList[i]
            currentOperation = opList[indexOfOp]
            when (currentOperation) {
                binding.buttonSummation -> {
                    result = firstNum + secondNum
                }

                binding.buttonSubstraction -> {
                    result = firstNum - secondNum
                }

                binding.buttonMultiplacation -> {
                    result = firstNum * secondNum
                }

                binding.buttonDivision -> {
                    result = firstNum / secondNum
                }
            }
            firstNum = result
            indexOfOp++
            i++
        }while (i < numList.size)
        binding.resultText.text = result.toString()
        numList.clear()
        opList.clear()
        newNum = result
    }

    private fun setUpOtherButtons()
    {
        val others = listOf(
            binding.buttonDelete,
            binding.buttonResult
        )
        for (i in others.indices)
        {
            others[i].setOnClickListener {
                onOthersClick(others[i])
            }
        }
    }

    private fun onOthersClick(choise: Button)
    {
        numList.add(newNum)
        when(choise)
        {
            binding.buttonDelete ->
            {
                firstNum = 0
                secondNum = 0
                binding.resultText.text = "0"
                result = 0
                newNum = 0
                numList.clear()
                opList.clear()
            }
            binding.buttonResult ->
            {
                makingCalculation()
            }
        }
    }
}