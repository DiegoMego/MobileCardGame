package pe.edu.ulima.ocholocos.views

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.DragEvent
import android.widget.LinearLayout
import android.widget.RelativeLayout
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.shared.Cards

class PlayedCardsView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private val cardFactory : CardFactory = CardFactory(context)
    private var topCardView : CardView? = null
    private var accRotation : Float = 0f

    init {
        this.setOnDragListener{ _ , e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED ->
                    e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                DragEvent.ACTION_DRAG_ENTERED -> true
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DROP -> {
                    val item : ClipData.Item = e.clipData.getItemAt(0)
                    val cardId : Int = item.text.toString().toInt()
                    val cardView : CardView = cardFactory.getCard(cardId)
                    if (cardView.numberMatch(topCardView!!) || cardView.suitMatch(topCardView!!)) {
                        putCard(cardView)
                    }
                    false
                }
                DragEvent.ACTION_DRAG_EXITED -> true
                DragEvent.ACTION_DRAG_ENDED -> true
                else -> false
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    fun putCard(cardView : CardView) : PlayedCardsView {
        setCardParams(cardView)
        addCard(cardView)
        return this
    }

    private fun addCard(cardView : CardView) {
        this.addView(cardView)
        topCardView = cardView
    }

    private fun setCardParams(cardView : CardView){
        cardView.layoutParams = LinearLayout.LayoutParams(
            120,
            120
        )
        cardView.rotation = this.accRotation
        this.accRotation = (this.accRotation + 30) % 180
    }
}