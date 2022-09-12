package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.security.KeyStore

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var wordToGuess = FourLetterWordList.getRandomFourLetterWord() // get a random word
        // function to check if guess if correct
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        fun reset() {

        }

        var btnCheck = findViewById<Button>(R.id.btncheck)
        var btnRestart = findViewById<Button>(R.id.btnRestart)
        val txFirstGuess = findViewById<TextView>(R.id.txFirstGuess)
        val txFirstCheck = findViewById<TextView>(R.id.txFirstCheck)
        val txSecondGuess = findViewById<TextView>(R.id.txSecondGuess)
        val txSecondCheck = findViewById<TextView>(R.id.txSecondCheck)
        val txThirdGuess = findViewById<TextView>(R.id.txThirdGuess)
        val txThirdCheck = findViewById<TextView>(R.id.txThirdCheck)
        var firstStatus = findViewById<TextView>(R.id.firstStatus)
        var firstStatusCheck = findViewById<TextView>(R.id.firstStatusCheck)
        var secondStatus = findViewById<TextView>(R.id.secondStatus)
        var secondStatusCheck = findViewById<TextView>(R.id.secondStatusCheck)
        var thirdStatus = findViewById<TextView>(R.id.thirdStatus)
        var thirdStatusCheck = findViewById<TextView>(R.id.thirdStatusCheck)
        var enterWord = findViewById<EditText>(R.id.enterWord)
        var word = findViewById<TextView>(R.id.word)
        //var strValue = word.text.toString()

        btnCheck.setOnClickListener {
            //Toast.makeText(it.context,"Clicked Button!", Toast.LENGTH_SHORT).show()
            counter ++

            if (counter == 1){
                // show the four letter word entered in editText to firstStatus line
                firstStatus.text == enterWord.text.toString()     //??unable to show? I used this method and both strValue method, both were unble to make it show
                // check if the word is same as wordToGuess word
                var result = checkGuess(enterWord.text.toString())
                // reflect the result in firstStatusCheck line
                firstStatusCheck.text == result

            }
            if (counter == 2){
                secondStatus.text == enterWord.text.toString()
                var result = checkGuess(enterWord.text.toString())
                secondStatusCheck.text = result

            }
            if (counter == 3){
                thirdStatus.text == enterWord.text.toString()
                var result = checkGuess(enterWord.text.toString())
                thirdStatusCheck.text = result
            }
            if (counter == 4){
                word.text == wordToGuess
                word.visibility = View.VISIBLE

                btnRestart.visibility = View.VISIBLE
                btnRestart.setOnClickListener {
                    //Toast.makeText(it.context,"Clicked Button!", Toast.LENGTH_SHORT).show()
                    // reset the app
                    reset()
                    /* var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                    firstStatus.text = "guess 1 word"
                    firstStatusCheck.text = "guess 1 check"
                    secondStatus.text = "guess 2 word"
                    secondStatusCheck.text = "guess 2 check"
                    thirdStatus.text = "guess 3 word"
                    thirdStatusCheck.text = "guess 3 check"
                    btnRestart.visibility = View.INVISIBLE
                    word.visibility = View.INVISIBLE */

                }
            }
        }

    }

}

