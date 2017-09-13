package com.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.solitaire.game.Card
import com.solitaire.game.GameModel
import com.solitaire.game.GamePresenter
import com.solitaire.game.cardsMap
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by voliveira on 12/09/2017.
 */
class WastePileView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) =
        ankoView({ WastePileView(it) }, 0, init)