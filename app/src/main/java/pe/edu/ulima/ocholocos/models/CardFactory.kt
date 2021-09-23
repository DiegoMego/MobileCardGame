package pe.edu.ulima.ocholocos.models

import android.content.Context
import pe.edu.ulima.ocholocos.R
import pe.edu.ulima.ocholocos.shared.*
import pe.edu.ulima.ocholocos.views.CardView

class CardFactory(context: Context) {
    var context : Context = context

    init {
        this.context = context
    }

    fun getCard(id: Int) : CardView {
        val number : Int = id % 100
        when (id) {
            ACE_OF_HEARTS -> return CardView(ACE_OF_HEARTS, HEARTS,number, R.drawable.heartsace, context)
            TWO_OF_HEARTS -> return CardView(TWO_OF_HEARTS, HEARTS,number, R.drawable.heartstwo, context)
            THREE_OF_HEARTS -> return CardView(THREE_OF_HEARTS, HEARTS,number, R.drawable.heartsthree, context)
            FOUR_OF_HEARTS -> return CardView(FOUR_OF_HEARTS, HEARTS,number, R.drawable.heartsfour, context)
            FIVE_OF_HEARTS -> return CardView(FIVE_OF_HEARTS, HEARTS,number, R.drawable.heartsfive, context)
            SIX_OF_HEARTS -> return CardView(SIX_OF_HEARTS, HEARTS,number, R.drawable.heartssix, context)
            SEVEN_OF_HEARTS -> return CardView(SEVEN_OF_HEARTS, HEARTS,number, R.drawable.heartsseven, context)
            EIGHT_OF_HEARTS -> return CardView(EIGHT_OF_HEARTS, HEARTS,number, R.drawable.heartseight, context)
            NINE_OF_HEARTS -> return CardView(NINE_OF_HEARTS, HEARTS,number, R.drawable.heartsnine, context)
            TEN_OF_HEARTS -> return CardView(TEN_OF_HEARTS, HEARTS,number, R.drawable.heartsten, context)
            JACK_OF_HEARTS -> return CardView(JACK_OF_HEARTS, HEARTS,number, R.drawable.heartsjack, context)
            QUEEN_OF_HEARTS -> return CardView(QUEEN_OF_HEARTS, HEARTS,number, R.drawable.heartsqueen, context)
            KING_OF_HEARTS -> return CardView(KING_OF_HEARTS, HEARTS,number, R.drawable.heartsking, context)
            ACE_OF_DIAMONDS -> return CardView(ACE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsace, context)
            TWO_OF_DIAMONDS -> return CardView(TWO_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondstwo, context)
            THREE_OF_DIAMONDS -> return CardView(THREE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsthree, context)
            FOUR_OF_DIAMONDS -> return CardView(FOUR_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsfour, context)
            FIVE_OF_DIAMONDS -> return CardView(FIVE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsfive, context)
            SIX_OF_DIAMONDS -> return CardView(SIX_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondssix, context)
            SEVEN_OF_DIAMONDS -> return CardView(SEVEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsseven, context)
            EIGHT_OF_DIAMONDS -> return CardView(EIGHT_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondseight, context)
            NINE_OF_DIAMONDS -> return CardView(NINE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsnine, context)
            TEN_OF_DIAMONDS -> return CardView(TEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsten, context)
            JACK_OF_DIAMONDS -> return CardView(JACK_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsjack, context)
            QUEEN_OF_DIAMONDS -> return CardView(QUEEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsqueen, context)
            KING_OF_DIAMONDS -> return CardView(KING_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsking, context)
            ACE_OF_CLUBS -> return CardView(ACE_OF_CLUBS, CLUBS,number, R.drawable.clubsace, context)
            TWO_OF_CLUBS -> return CardView(TWO_OF_CLUBS, CLUBS,number, R.drawable.clubstwo, context)
            THREE_OF_CLUBS -> return CardView(THREE_OF_CLUBS, CLUBS,number, R.drawable.clubsthree, context)
            FOUR_OF_CLUBS -> return CardView(FOUR_OF_CLUBS, CLUBS,number, R.drawable.clubsfour, context)
            FIVE_OF_CLUBS -> return CardView(FIVE_OF_CLUBS, CLUBS,number, R.drawable.clubsfive, context)
            SIX_OF_CLUBS -> return CardView(SIX_OF_CLUBS, CLUBS,number, R.drawable.clubssix, context)
            SEVEN_OF_CLUBS -> return CardView(SEVEN_OF_CLUBS, CLUBS,number, R.drawable.clubsseven, context)
            EIGHT_OF_CLUBS -> return CardView(EIGHT_OF_CLUBS, CLUBS,number, R.drawable.clubseight, context)
            NINE_OF_CLUBS -> return CardView(NINE_OF_CLUBS, CLUBS,number, R.drawable.clubsnine, context)
            TEN_OF_CLUBS -> return CardView(TEN_OF_CLUBS, CLUBS,number, R.drawable.clubsten, context)
            JACK_OF_CLUBS -> return CardView(JACK_OF_CLUBS, CLUBS,number, R.drawable.clubsjack, context)
            QUEEN_OF_CLUBS -> return CardView(QUEEN_OF_CLUBS, CLUBS,number, R.drawable.clubsqueen, context)
            KING_OF_CLUBS -> return CardView(KING_OF_CLUBS, CLUBS,number, R.drawable.clubsking, context)
            ACE_OF_SPADES -> return CardView(ACE_OF_SPADES, SPADES,number, R.drawable.spadesace, context)
            TWO_OF_SPADES -> return CardView(TWO_OF_SPADES, SPADES,number, R.drawable.spadestwo, context)
            THREE_OF_SPADES -> return CardView(THREE_OF_SPADES, SPADES,number, R.drawable.spadesthree, context)
            FOUR_OF_SPADES -> return CardView(FOUR_OF_SPADES, SPADES,number, R.drawable.spadesfour, context)
            FIVE_OF_SPADES -> return CardView(FIVE_OF_SPADES, SPADES,number, R.drawable.spadesfive, context)
            SIX_OF_SPADES -> return CardView(SIX_OF_SPADES, SPADES,number, R.drawable.spadessix, context)
            SEVEN_OF_SPADES -> return CardView(SEVEN_OF_SPADES, SPADES,number, R.drawable.spadesseven, context)
            EIGHT_OF_SPADES -> return CardView(EIGHT_OF_SPADES, SPADES,number, R.drawable.spadeseight, context)
            NINE_OF_SPADES -> return CardView(NINE_OF_SPADES, SPADES,number, R.drawable.spadesnine, context)
            TEN_OF_SPADES -> return CardView(TEN_OF_SPADES, SPADES,number, R.drawable.spadesten, context)
            JACK_OF_SPADES -> return CardView(JACK_OF_SPADES, SPADES,number, R.drawable.spadesjack, context)
            QUEEN_OF_SPADES -> return CardView(QUEEN_OF_SPADES, SPADES,number, R.drawable.spadesqueen, context)
            KING_OF_SPADES -> return CardView(KING_OF_SPADES, SPADES,number, R.drawable.heartsking, context)
            else -> return CardView(ACE_OF_HEARTS, HEARTS,number, R.drawable.heartsace, context)
        }
    }
}