package pe.edu.ulima.ocholocos

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import pe.edu.ulima.ocholocos.shared.Deck
import pe.edu.ulima.ocholocos.shared.JACK
import pe.edu.ulima.ocholocos.shared.QUEEN
import pe.edu.ulima.ocholocos.shared.KING
import pe.edu.ulima.ocholocos.views.*

class MainActivity : AppCompatActivity() {
    private val cardFactory : CardFactory = CardFactory(this)
    private val numberOfPlayers = 3
    private var drawMultiplier = 1
    private var currentPlayerIndex = 0
    private var gameFlow = 1
    private lateinit var player : TextView
    private lateinit var currentPlayerHand : PlayerHand
    private lateinit var playersHands : List<PlayerHand>
    private lateinit var drawCardLayout : ConstraintLayout
    private lateinit var drawnCardLayout : RelativeLayout
    private lateinit var butPlay : Button
    private lateinit var butDraw : Button
    private lateinit var butDrawFromDeck : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardTable = findViewById<CardTable>(R.id.cardTable)
        val playedCardsLayout = findViewById<PlayedCards>(R.id.playedCardsLayout)

        this.playersHands = listOf(
            findViewById(R.id.playerOneHand),
            findViewById(R.id.playerTwoHand),
            findViewById(R.id.playerThreeHand)
        )

        this.player = findViewById(R.id.tviPlayer)
        this.currentPlayerHand = playersHands[0]
        this.drawCardLayout = findViewById(R.id.claDrawCard)
        this.drawnCardLayout = findViewById(R.id.rlaDrawnCard)
        this.butPlay = findViewById(R.id.butPlay)
        this.butDraw = findViewById(R.id.butDraw)
        this.butDrawFromDeck = findViewById(R.id.butDrawCardFromDeck)

        cardTable.setOnDragListener{ _ , e ->
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED ->
                    e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                DragEvent.ACTION_DRAG_ENTERED -> true
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED -> true
                DragEvent.ACTION_DROP -> {
                    val item : ClipData.Item = e.clipData.getItemAt(0)
                    val cardIndex : Int = item.text.toString().toInt()
                    val card : Card = currentPlayerHand.getCard(cardIndex)
                    if (playedCardsLayout.cardMatchesNumberOrColor(card)) {
                        val cardPlayed = currentPlayerHand.playCard(cardIndex)
                        playedCardsLayout.putCard(cardPlayed)
                        nextPlayer()
                        triggerCardMechanic(card.number)
                        true
                    }
                    false
                }
                else -> true
            }
        }

        this.butPlay.setOnClickListener{ _ : View ->
            val card : Card = this.drawnCardLayout.getChildAt(0) as Card
            this.drawnCardLayout.removeViewAt(0)
            playedCardsLayout.putCard(card)
            triggerCardMechanic(card.number)
        }

        this.butDraw.setOnClickListener{ _ : View ->
            val card : Card = this.drawnCardLayout.getChildAt(0) as Card
            this.drawnCardLayout.removeViewAt(0)
            currentPlayerHand.DrawCard(card)
        }

        this.butDrawFromDeck.setOnClickListener{ _ : View ->
            currentPlayerHand.DrawCard()
        }
    }

    private fun nextPlayer() {
        currentPlayerHand.visibility = View.GONE
        currentPlayerIndex = (currentPlayerIndex + gameFlow) % numberOfPlayers
        currentPlayerHand = playersHands[currentPlayerIndex]
        player.text = "Jugador ${currentPlayerIndex + 1}"
        currentPlayerHand.visibility = View.VISIBLE
    }

    fun triggerCardMechanic(cardNumber: Int) {
        when(cardNumber) {
            KING -> drawThreeCards(3 * drawMultiplier)
        }
    }

    fun drawThreeCards(toDraw : Int, drawn : Int = 0) {
        hideDrawCardLayout()
        if (this.drawnCardLayout.childCount > 0) this.drawnCardLayout.removeAllViews()
//        this.butPlay.isEnabled = false
        var card : Card = cardFactory.getCard(Deck.getCard())
        var drawn = drawn + 1
        if (card.number == KING) {
            card.layoutParams = getCardLayoutParams()
//            this.butPlay.isEnabled = true
            this.drawMultiplier++
            this.drawnCardLayout.addView(card)
            showDrawCardLayout()
        } else if (drawn < toDraw) {
            this.currentPlayerHand.DrawCard(card)
            drawThreeCards(toDraw, drawn)
        } else {
            this.currentPlayerHand.DrawCard(card)
            this.drawMultiplier = 1
        }
    }

    private fun showDrawCardLayout(){
        this.drawCardLayout.visibility = View.VISIBLE
        this.currentPlayerHand.visibility = View.GONE
        this.butDrawFromDeck.visibility = View.GONE
    }

    private fun hideDrawCardLayout() {
        this.drawCardLayout.visibility = View.GONE
        this.currentPlayerHand.visibility = View.VISIBLE
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