package com.poteapp.coroutineandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val RESULTONE = "Result #1"
    private val RESULTWO = "Result #2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            // IO, Main, Default
            CoroutineScope(IO).launch {
                fakeApiRequest()
            }
        }
    }
    
    private fun setNewText(input: String) {
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }

    private suspend fun setTextOnMainThread(input: String) {
        withContext(Main) {
            setNewText((input))
        }
    }

    private suspend fun fakeApiRequest() {
        val result1 = getResult1FromApi()
        println("debug: $result1")
        setTextOnMainThread(result1)

        val result2 = getResult2FromApi(result1)
        setTextOnMainThread(result2)
    }

    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000)
        return RESULTONE
    }

    private suspend fun getResult2FromApi(result1: String): String {
        logThread("getResult2FromApi")
        delay(1000)
        return RESULTWO
    }

    private suspend fun logThread(methodNAme: String) {
        println("debug: ${methodNAme}: ${Thread.currentThread().name}")
    }
}