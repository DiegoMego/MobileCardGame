package pe.edu.ulima.ocholocos.views

import android.content.Context
import pe.edu.ulima.ocholocos.R
import pe.edu.ulima.ocholocos.shared.*

class CardFactory(context: Context) {
    var context : Context = context

    init {
        this.context = context
    }

    fun getCard(id: Int) : Card {
        val number : Int = id % 100
        when (id) {
            ACE_OF_HEARTS -> return Card(ACE_OF_HEARTS, HEARTS,number, R.drawable.heartsace, context)
            TWO_OF_HEARTS -> return Card(TWO_OF_HEARTS, HEARTS,number, R.drawable.heartstwo, context)
            THREE_OF_HEARTS -> return Card(THREE_OF_HEARTS, HEARTS,number, R.drawable.heartsthree, context)
            FOUR_OF_HEARTS -> return Card(FOUR_OF_HEARTS, HEARTS,number, R.drawable.heartsfour, context)
            FIVE_OF_HEARTS -> return Card(FIVE_OF_HEARTS, HEARTS,number, R.drawable.heartsfive, context)
            SIX_OF_HEARTS -> return Card(SIX_OF_HEARTS, HEARTS,number, R.drawable.heartssix, context)
            SEVEN_OF_HEARTS -> return Card(SEVEN_OF_HEARTS, HEARTS,number, R.drawable.heartsseven, context)
            EIGHT_OF_HEARTS -> return Card(EIGHT_OF_HEARTS, HEARTS,number, R.drawable.heartseight, context)
            NINE_OF_HEARTS -> return Card(NINE_OF_HEARTS, HEARTS,number, R.drawable.heartsnine, context)
            TEN_OF_HEARTS -> return Card(TEN_OF_HEARTS, HEARTS,number, R.drawable.heartsten, context)
            JACK_OF_HEARTS -> return Card(JACK_OF_HEARTS, HEARTS,number, R.drawable.heartsjack, context)
            QUEEN_OF_HEARTS -> return Card(QUEEN_OF_HEARTS, HEARTS,number, R.drawable.heartsqueen, context)
            KING_OF_HEARTS -> return Card(KING_OF_HEARTS, HEARTS,number, R.drawable.heartsking, context)
            ACE_OF_DIAMONDS -> return Card(ACE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsace, context)
            TWO_OF_DIAMONDS -> return Card(TWO_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondstwo, context)
            THREE_OF_DIAMONDS -> return Card(THREE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsthree, context)
            FOUR_OF_DIAMONDS -> return Card(FOUR_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsfour, context)
            FIVE_OF_DIAMONDS -> return Card(FIVE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsfive, context)
            SIX_OF_DIAMONDS -> return Card(SIX_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondssix, context)
            SEVEN_OF_DIAMONDS -> return Card(SEVEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsseven, context)
            EIGHT_OF_DIAMONDS -> return Card(EIGHT_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondseight, context)
            NINE_OF_DIAMONDS -> return Card(NINE_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsnine, context)
            TEN_OF_DIAMONDS -> return Card(TEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsten, context)
            JACK_OF_DIAMONDS -> return Card(JACK_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsjack, context)
            QUEEN_OF_DIAMONDS -> return Card(QUEEN_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsqueen, context)
            KING_OF_DIAMONDS -> return Card(KING_OF_DIAMONDS, DIAMONDS,number, R.drawable.diamondsking, context)
            ACE_OF_CLUBS -> return Card(ACE_OF_CLUBS, CLUBS,number, R.drawable.clubsace, context)
            TWO_OF_CLUBS -> return Card(TWO_OF_CLUBS, CLUBS,number, R.drawable.clubstwo, context)
            THREE_OF_CLUBS -> return Card(THREE_OF_CLUBS, CLUBS,number, R.drawable.clubsthree, context)
            FOUR_OF_CLUBS -> return Card(FOUR_OF_CLUBS, CLUBS,number, R.drawable.clubsfour, context)
            FIVE_OF_CLUBS -> return Card(FIVE_OF_CLUBS, CLUBS,number, R.drawable.clubsfive, context)
            SIX_OF_CLUBS -> return Card(SIX_OF_CLUBS, CLUBS,number, R.drawable.clubssix, context)
            SEVEN_OF_CLUBS -> return Card(SEVEN_OF_CLUBS, CLUBS,number, R.drawable.clubsseven, context)
            EIGHT_OF_CLUBS -> return Card(EIGHT_OF_CLUBS, CLUBS,number, R.drawable.clubseight, context)
            NINE_OF_CLUBS -> return Card(NINE_OF_CLUBS, CLUBS,number, R.drawable.clubsnine, context)
            TEN_OF_CLUBS -> return Card(TEN_OF_CLUBS, CLUBS,number, R.drawable.clubsten, context)
            JACK_OF_CLUBS -> return Card(JACK_OF_CLUBS, CLUBS,number, R.drawable.clubsjack, context)
            QUEEN_OF_CLUBS -> return Card(QUEEN_OF_CLUBS, CLUBS,number, R.drawable.clubsqueen, context)
            KING_OF_CLUBS -> return Card(KING_OF_CLUBS, CLUBS,number, R.drawable.clubsking, context)
            ACE_OF_SPADES -> return Card(ACE_OF_SPADES, SPADES,number, R.drawable.spadesace, context)
            TWO_OF_SPADES -> return Card(TWO_OF_SPADES, SPADES,number, R.drawable.spadestwo, context)
            THREE_OF_SPADES -> return Card(THREE_OF_SPADES, SPADES,number, R.drawable.spadesthree, context)
            FOUR_OF_SPADES -> return Card(FOUR_OF_SPADES, SPADES,number, R.drawable.spadesfour, context)
            FIVE_OF_SPADES -> return Card(FIVE_OF_SPADES, SPADES,number, R.drawable.spadesfive, context)
            SIX_OF_SPADES -> return Card(SIX_OF_SPADES, SPADES,number, R.drawable.spadessix, context)
            SEVEN_OF_SPADES -> return Card(SEVEN_OF_SPADES, SPADES,number, R.drawable.spadesseven, context)
            EIGHT_OF_SPADES -> return Card(EIGHT_OF_SPADES, SPADES,number, R.drawable.spadeseight, context)
            NINE_OF_SPADES -> return Card(NINE_OF_SPADES, SPADES,number, R.drawable.spadesnine, context)
            TEN_OF_SPADES -> return Card(TEN_OF_SPADES, SPADES,number, R.drawable.spadesten, context)
            JACK_OF_SPADES -> return Card(JACK_OF_SPADES, SPADES,number, R.drawable.spadesjack, context)
            QUEEN_OF_SPADES -> return Card(QUEEN_OF_SPADES, SPADES,number, R.drawable.spadesqueen, context)
            KING_OF_SPADES -> return Card(KING_OF_SPADES, SPADES,number, R.drawable.heartsking, context)
            else -> return Card(ACE_OF_HEARTS, HEARTS,number, R.drawable.heartsace, context)
        }
    }
}