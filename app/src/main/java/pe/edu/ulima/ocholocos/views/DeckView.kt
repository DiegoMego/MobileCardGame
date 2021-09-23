package pe.edu.ulima.ocholocos.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.shared.Cards
import pe.edu.ulima.ocholocos.shared.HAND_SIZE

class DeckView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    private val cardFactory : CardFactory = CardFactory(context)
    private var cards : ArrayList<Int> = ArrayList()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun fill() : DeckView {
        this.cards.addAll(Cards.getDeck())
        return this
    }

    fun getPlayerHand() : ArrayList<CardView> {
        var playerCards : ArrayList<CardView> = ArrayList()
        val size : Int = this.cards.size
        for (i in 1..HAND_SIZE) {
            playerCards.add(cardFactory.getCard(cards.removeAt(size - i)))
        }
        return playerCards
    }

    fun getCard() : CardView {
        return cardFactory.getCard(cards.removeAt(cards.size - 1))
    }
}