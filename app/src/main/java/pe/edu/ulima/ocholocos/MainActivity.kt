package pe.edu.ulima.ocholocos

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import pe.edu.ulima.ocholocos.models.CardFactory
import pe.edu.ulima.ocholocos.shared.Cards
import pe.edu.ulima.ocholocos.shared.KING
import pe.edu.ulima.ocholocos.views.*

class MainActivity : AppCompatActivity() {
    private val cardFactory : CardFactory = CardFactory(this)
    private val numberOfPlayers = 3
    private var drawMultiplier = 1
    private var currentPlayerIndex = 0
    private var gameFlow = 1
    private lateinit var player : TextView
    private lateinit var currentPlayerHandView : PlayerHandView
    private lateinit var playersHandViews : List<PlayerHandView>
    private lateinit var drawCardLayout : ConstraintLayout
    private lateinit var drawnCardLayout : RelativeLayout
    private lateinit var deck : DeckView
    private lateinit var butPlay : Button
    private lateinit var butDraw : Button
    private lateinit var butDrawFromDeck : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.deck = findViewById<DeckView>(R.id.ivi_deck).fill()
        val playedCardsLayout = findViewById<PlayedCardsView>(R.id.playedCardsLayout).putCard(this.deck.getCard())

        this.playersHandViews = listOf(
            findViewById<PlayerHandView>(R.id.playerOneHand).getHand(deck.getPlayerHand()),
            findViewById<PlayerHandView>(R.id.playerTwoHand).getHand(deck.getPlayerHand()),
            findViewById<PlayerHandView>(R.id.playerThreeHand).getHand(deck.getPlayerHand())
        )
        this.currentPlayerHandView = playersHandViews[0]

        this.player = findViewById(R.id.tviPlayer)
        this.drawCardLayout = findViewById(R.id.claDrawCard)
        this.drawnCardLayout = findViewById(R.id.rlaDrawnCard)
        this.butPlay = findViewById(R.id.butPlay)
        this.butDraw = findViewById(R.id.butDraw)
        this.butDrawFromDeck = findViewById(R.id.butDrawCardFromDeck)

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
    }

    private fun nextPlayer() {
        currentPlayerHandView.visibility = View.GONE
        currentPlayerIndex = (currentPlayerIndex + gameFlow) % numberOfPlayers
        currentPlayerHandView = playersHandViews[currentPlayerIndex]
        player.text = "Jugador ${currentPlayerIndex + 1}"
        currentPlayerHandView.visibility = View.VISIBLE
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