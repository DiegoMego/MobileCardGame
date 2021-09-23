package pe.edu.ulima.ocholocos.views

import android.content.Context
import android.graphics.Canvas
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import pe.edu.ulima.ocholocos.R

class CardView(cardId : Int, type : Int, number : Int, image : Int, context: Context) : AppCompatImageView(context) {
    val cardId : Int = cardId
    val suit : Int = type
    val number: Int = number
    val image: Int = image

    init {
        //this.setImageResource(image)
        this.setImageResource(R.drawable.heartsking)
        this.layoutParams = ViewGroup.LayoutParams(
            200,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        this.tag = cardId.toString()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun suitMatch(card : CardView) : Boolean {
        return this.suit == card.suit
    }

    fun numberMatch(card : CardView) : Boolean {
        return this.number == card.number
    }
}