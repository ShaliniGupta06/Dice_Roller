package com.asj.dicerollernew

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.asj.dicerollernew.R

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    // Function ke andar function nhi likhna hai

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        var dice = Dice(6)
        var diceRoll = dice.roll()
        // Update the screen with the dice roll
        val firstDiceImage: ImageView = setImage(diceRoll, 1)

        dice = Dice(6)
        diceRoll = dice.roll()
        val secondDiceImage: ImageView = setImage(diceRoll, 2)

    }
    private fun setImage(rollValue: Int, diceNo: Int): ImageView{
        // Find the ImageView in the layout
        val diceImage: ImageView = when (diceNo) {
            1 -> {
                findViewById(R.id.first_dice)
            }
            else -> {
                findViewById(R.id.second_dice)
            }
        }
        // Determine which drawable resource ID to use based on the dice roll
        val selectImage = when (rollValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(selectImage)
        // Update the content description
        diceImage.contentDescription = rollValue.toString()
        return diceImage
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
