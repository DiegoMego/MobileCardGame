package pe.edu.ulima.ocholocos.views

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.forEach
import pe.edu.ulima.ocholocos.R
import pe.edu.ulima.ocholocos.shared.Deck
import pe.edu.ulima.ocholocos.shared.HAND_SIZE

class PlayerHand(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val cardFactory : CardFactory = CardFactory(context)
    private val hand : ArrayList<Card> = ArrayList()
    private val onClickListener : OnLongClickListener = OnLongClickListener { v : View ->
        val cardIndex = hand.indexOf(v).toString()
        val item = ClipData.Item(cardIndex as? CharSequence)

        val dragData = ClipData(
            cardIndex as? CharSequence,
            arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
            item
        )

        val shadow = CardShadow(v)

        v.startDrag(
            dragData,
            shadow,
            v,
            0
        )
    }

    init {
        this.drawHand()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    private fun drawHand() {
        val cards : List<Int> = Deck.getPlayerHand()
        for (c in cards) {
            val card : Card = cardFactory.getCard(c)
            card.setOnLongClickListener(onClickListener)
            hand.add(card)
            this.addView(card)
        }
    }

    fun DrawCard() : Card {
        val card : Card = cardFactory.getCard(Deck.getCard())
        card.setOnLongClickListener(onClickListener)
        hand.add(0, card)
        val mFade : Fade = Fade(Fade.IN)
        TransitionManager.beginDelayedTransition(this, mFade)
        this.addView(card, 0)
        return card
    }

    fun DrawCard(card : Card) {
        card.setOnLongClickListener(onClickListener)
        hand.add(0, card)
        val mFade : Fade = Fade(Fade.IN)
        TransitionManager.beginDelayedTransition(this, mFade)
        this.addView(card, 0)
    }

    fun playCard(index : Int) : Card {
        this.removeViewAt(index)
        return this.hand.removeAt(index)
    }

    fun getCard(index : Int) : Card {
        return this.hand[index]
    }
}