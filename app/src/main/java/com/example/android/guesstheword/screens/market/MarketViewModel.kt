package com.example.android.guesstheword.screens.market

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * ViewModel containing all the logic needed to run the game
 */
class MarketViewModel : ViewModel() {

    // The current word
    var word = ""

    // The current score
    var score = 0

    val list = arrayListOf<String>()
//    println("list.isEmpty() is ${list.isEmpty()}") // true

//    list.addAll(listOf(1, 2, 3))
//    println(list) // [1, 2, 3]


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "apple",
                "orange",
                "banana",
                "kiwi",
                "wine"
        )
        wordList.shuffle()
    }

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        score--
        nextWord()
    }
    fun onCorrect() {
        score++
        nextWord()
        list.addAll(listOf(word))
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }
}