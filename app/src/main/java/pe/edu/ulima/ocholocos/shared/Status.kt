package pe.edu.ulima.ocholocos.shared

import androidx.lifecycle.MutableLiveData
import pe.edu.ulima.ocholocos.views.CardView

object Status {
    var game : GAME_STATUS = GAME_STATUS.CARD_PLAYED
    var player : MutableLiveData<PLAYER_STATUS> = MutableLiveData<PLAYER_STATUS>()//.START_OF_TURN
    var flow : Int = TO_NEXT

    fun setStatus(cardPlayed : CardView, cardOnTable : CardView) {
        if (cardPlayed.numberMatch(cardOnTable)) {
            this.game = GAME_STATUS.CARD_PLAYED
            this.player.value = PLAYER_STATUS.ACTIVE
        }
        else if (cardPlayed.suitMatch(cardOnTable)) {
            this.game = GAME_STATUS.CARD_PLAYED
            this.player.value = PLAYER_STATUS.END_OF_TURN
        }

        if (cardPlayed.number == KING) {
            this.game = GAME_STATUS.KING_PLAYED
        }
    }
}