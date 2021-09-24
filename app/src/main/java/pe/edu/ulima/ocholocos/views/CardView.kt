package pe.edu.ulima.ocholocos.views

import android.content.Context
import android.graphics.Canvas
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import pe.edu.ulima.ocholocos.shared.GAME_STATUS
import pe.edu.ulima.ocholocos.shared.KING
import pe.edu.ulima.ocholocos.shared.PLAYER_STATUS
import pe.edu.ulima.ocholocos.shared.Status

class CardView(cardId : Int, suit : Int, number : Int, image : Int, context: Context) : AppCompatImageView(context) {
    val cardId : Int = cardId
    val suit : Int = suit
    val number: Int = number
    val image: Int = image

    init {
        this.setImageResource(image)
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
        if (Status.game == GAME_STATUS.KING_PLAYED && Status.player.value == PLAYER_STATUS.START_OF_TURN) {
            return this.number == KING
        }
        return this.suit == card.suit
    }

    fun numberMatch(card : CardView) : Boolean {
        if (Status.game == GAME_STATUS.KING_PLAYED && Status.player.value == PLAYER_STATUS.START_OF_TURN) {
            return this.number == KING
        }
        return this.number == card.number
    }
}