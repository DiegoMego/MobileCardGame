package pe.edu.ulima.ocholocos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.shared.GAME_STATUS
import pe.edu.ulima.ocholocos.shared.NUMBER_OF_PLAYERS
import pe.edu.ulima.ocholocos.shared.PLAYER_STATUS
import pe.edu.ulima.ocholocos.shared.Status
import pe.edu.ulima.ocholocos.views.*

class GameActivity : AppCompatActivity() {
    private var currentPlayerIndex = 0
    private lateinit var player : TextView
    private lateinit var currentPlayerHandView : PlayerHandView
    private lateinit var playersHandViews : List<PlayerHandView>
    private lateinit var drawCardLayout : ConstraintLayout
    private lateinit var drawnCardLayout : RelativeLayout
    private lateinit var deck : DeckView
    private lateinit var butPlay : Button
    private lateinit var butDraw : Button
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

        //played cards in center
        this.drawCardLayout = findViewById(R.id.claDrawCard)
        this.drawnCardLayout = findViewById(R.id.rlaDrawnCard)

        //buttons
        this.butPlay = findViewById(R.id.butPlay)
        this.butDraw = findViewById(R.id.butDraw)
        this.butDrawFromDeck = findViewById(R.id.butDrawCardFromDeck)
        this.butEndTurn = findViewById(R.id.butEndTurn)
        //endregion

        //region player status
        Status.player.value = PLAYER_STATUS.START_OF_TURN

        Status.player.observe(this, Observer {
            when (it) {
                PLAYER_STATUS.START_OF_TURN -> {
                    butEndTurn.isEnabled = false
                    currentPlayerHandView.visibility = View.VISIBLE
                    if (Status.game == GAME_STATUS.KING_PLAYED) {
                        //Draw 3 cards
                    }
                }
                PLAYER_STATUS.ACTIVE -> {
                    //Show end of turn button
                    butEndTurn.isEnabled = true
                }
                PLAYER_STATUS.END_OF_TURN -> {
                    //Show end of turn button
                    currentPlayerHandView.visibility = View.GONE
                    butEndTurn.isEnabled = true
                }
            }
        })
        //endregion

        //region listeners
        this.butPlay.setOnClickListener{ _ : View ->
            val cardView : CardView = this.drawnCardLayout.getChildAt(0) as CardView
            this.drawnCardLayout.removeViewAt(0)
            playedCardsLayout.putCard(cardView)
            triggerCardMechanic(cardView.number)
        }

        this.butDraw.setOnClickListener{ _ : View ->
            val cardView : CardView = this.drawnCardLayout.getChildAt(0) as CardView
            this.drawnCardLayout.removeViewAt(0)
            currentPlayerHandView.getCard(cardView)
        }

        this.butDrawFromDeck.setOnClickListener{ _ : View ->
            currentPlayerHandView.getCard(deck.getCard())
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

    fun triggerCardMechanic(cardNumber: Int) {
        /*when(cardNumber) {
            KING -> drawThreeCards(3 * drawMultiplier)
        }*/
    }

    /*fun drawThreeCards(toDraw : Int, drawn : Int = 0) {
        hideDrawCardLayout()
        if (this.drawnCardLayout.childCount > 0) this.drawnCardLayout.removeAllViews()
        var cardView : CardView = cardFactory.getCard(Cards.getCard())
        var drawn = drawn + 1
        if (cardView.number == KING) {
            cardView.layoutParams = getCardLayoutParams()
            this.drawMultiplier++
            this.drawnCardLayout.addView(cardView)
            showDrawCardLayout()
        } else if (drawn < toDraw) {
            this.currentPlayerHandView.DrawCard(cardView)
            drawThreeCards(toDraw, drawn)
        } else {
            this.currentPlayerHandView.DrawCard(cardView)
            this.drawMultiplier = 1
        }
    }*/

    private fun showDrawCardLayout(){
        this.drawCardLayout.visibility = View.VISIBLE
        this.currentPlayerHandView.visibility = View.GONE
        this.butDrawFromDeck.visibility = View.GONE
    }

    private fun hideDrawCardLayout() {
        this.drawCardLayout.visibility = View.GONE
        this.currentPlayerHandView.visibility = View.VISIBLE
        this.butDrawFromDeck.visibility = View.VISIBLE
    }

    private fun getCardLayoutParams() : RelativeLayout.LayoutParams {
        var layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        return layoutParams
    }
}