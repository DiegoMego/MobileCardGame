package pe.edu.ulima.ocholocos.views

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.widget.LinearLayout
import pe.edu.ulima.ocholocos.R
import pe.edu.ulima.ocholocos.shared.Deck

class PlayedCards(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val cards : ArrayList<Card> = ArrayList()
    private val cardFactory : CardFactory = CardFactory(context)
    private var topCard : Card? = null

    init {
        val card = cardFactory.getCard(Deck.getCard())
        setCardParams(card)
        addCard(card)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun putCard(card : Card) : Boolean {
        removeTopCard()
        setCardParams(card)
        addCard(card)
        return true
    }

    private fun addCard(card : Card) {
        cards.add(card)
        this.addView(card)
        topCard = card
    }

    private fun removeTopCard() {
        this.removeView(topCard)
    }

    private fun setCardParams(card : Card){
        card.layoutParams = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            3f
        )
    }

    fun cardMatchesNumberOrColor(card : Card) : Boolean {
        return card.type == topCard?.type || card.number == topCard?.number
    }
}