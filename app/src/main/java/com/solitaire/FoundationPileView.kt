package com.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.solitaire.game.GameModel
import com.solitaire.game.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by voliveira on 12/09/2017.
 */
class FoundationPileView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) =
        ankoView({ FoundationPileView(it, index) }, 0, init)


