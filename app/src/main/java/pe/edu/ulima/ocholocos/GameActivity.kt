package pe.edu.ulima.ocholocos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.shared.*
import pe.edu.ulima.ocholocos.views.*

class GameActivity : AppCompatActivity() {
    private var currentPlayerIndex = 0
    private lateinit var player : TextView
    private lateinit var currentPlayerHandView : PlayerHandView
    private lateinit var playersHandViews : List<PlayerHandView>
    private lateinit var drawCardLayout : ConstraintLayout
    private lateinit var deck : DeckView
    private lateinit var butDrawFromDeck : Button
    private lateinit var butEndTurn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //region view variables

        //deck
        this.deck = findViewById<DeckView>(R.id.ivi_deck).fill()

        //players
        val playedCardsLayout = findViewById<PlayedCardsView>(R.id.playedCardsLayout).putCard(this.deck.getCard())
        this.playersHandViews = listOf(
            findViewById<PlayerHandView>(R.id.playerOneHand).getCards(deck.getPlayerHand()),
            findViewById<PlayerHandView>(R.id.playerTwoHand).getCards(deck.getPlayerHand()),
            findViewById<PlayerHandView>(R.id.playerThreeHand).getCards(deck.getPlayerHand())
        )
        this.currentPlayerHandView = playersHandViews[0]

        //player name text
        this.player = findViewById(R.id.tviPlayer)
        var playerDrawText = findViewById<TextView>(R.id.tviDrawCards)

        //buttons
        this.butDrawFromDeck = findViewById(R.id.butDrawCardFromDeck)
        this.butEndTurn = findViewById(R.id.butEndTurn)
        //endregion

        //region player status
        Status.player.value = PLAYER_STATUS.START_OF_TURN

        Status.player.observe(this, Observer {
            when (it) {
                PLAYER_STATUS.START_OF_TURN -> {
                    butEndTurn.isEnabled = false
                    this.butDrawFromDeck.isEnabled = true
                    currentPlayerHandView.visibility = View.VISIBLE
                    if (Status.game == GAME_STATUS.KING_PLAYED) {
                        Status.drawnCards = 0
                        playerDrawText.visibility = View.VISIBLE
                        playerDrawText.text = "Robe ${(Status.drawMultiplier * DRAW_THREE - Status.drawnCards)}"
                    }
                }
                PLAYER_STATUS.ACTIVE -> {
                    //Show end of turn button
                    butEndTurn.isEnabled = true
                    this.butDrawFromDeck.isEnabled = false
                }
                PLAYER_STATUS.END_OF_TURN -> {
                    //Show end of turn button
                    currentPlayerHandView.visibility = View.GONE
                    butEndTurn.isEnabled = true
                    this.butDrawFromDeck.isEnabled = false
                }
            }
        })
        //endregion

        //region listeners
        this.butDrawFromDeck.setOnClickListener{ _ : View ->
            currentPlayerHandView.getCard(deck.getCard())
            if (Status.game == GAME_STATUS.KING_PLAYED &&
                Status.drawnCards < Status.drawMultiplier * DRAW_THREE){
                Status.drawnCards++
                playerDrawText.text = "Robe ${(Status.drawMultiplier * DRAW_THREE - Status.drawnCards)}"
            } else if (Status.game == GAME_STATUS.KING_PLAYED) {
                Status.player.value = PLAYER_STATUS.ACTIVE
                playerDrawText.visibility = View.GONE
            } else {
                playerDrawText.visibility = View.GONE
                Status.player.value = PLAYER_STATUS.ACTIVE
            }
        }

        this.butEndTurn.setOnClickListener{ _ : View ->
            nextPlayer()
        }
        //endregion
    }

    private fun nextPlayer() {
        currentPlayerHandView.visibility = View.GONE
        currentPlayerIndex = (currentPlayerIndex + Status.flow) % NUMBER_OF_PLAYERS
        currentPlayerHandView = playersHandViews[currentPlayerIndex]
        player.text = "Jugador ${currentPlayerIndex + 1}"
        Status.player.value = PLAYER_STATUS.START_OF_TURN
    }
}