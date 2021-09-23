package pe.edu.ulima.ocholocos.views

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.graphics.Canvas
import android.transition.Fade
import android.transition.TransitionManager
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.LinearLayout
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.models.CardShadow
import pe.edu.ulima.ocholocos.shared.PLAYER_STATUS
import pe.edu.ulima.ocholocos.shared.Status

class PlayerHandView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val cardFactory : CardFactory = CardFactory(context)
    private var cardIndex : Int? = null
    private val listener : OnLongClickListener = OnLongClickListener { v : View ->
        if (v is CardView) {
            cardIndex = indexOfChild(v)
            val item = ClipData.Item(v.tag as? CharSequence)

            val dragData = ClipData(
                v.tag as? CharSequence,
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
        true
    }

    init {
        this.setOnDragListener{ _ , e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED ->
                    e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                DragEvent.ACTION_DRAG_ENDED -> {
                    if (e.result) {
                        removeViewAt(cardIndex!!)
                        cardIndex = null
                    }
                    false
                }
                else -> false
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun getCards(cards : ArrayList<CardView>) : PlayerHandView {
        cards.forEach { card : CardView ->
            card.setOnLongClickListener(listener)
            addView(card)
        }
        return this
    }

    fun getCard(cardView : CardView) {
        cardView.setOnLongClickListener(listener)
        val mFade : Fade = Fade(Fade.IN)
        TransitionManager.beginDelayedTransition(this, mFade)
        this.addView(cardView, 0)
    }
}