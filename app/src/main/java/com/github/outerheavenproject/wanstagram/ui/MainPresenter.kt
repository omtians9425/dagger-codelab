package com.github.outerheavenproject.wanstagram.ui

import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionSink
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContruct.View
) : MainContruct.Presenter, DogActionSink {
    private val shareList = mutableSetOf<String>()

    override fun start() {
    }

    override fun write(url: String) {
        shareList.add(url)
    }

    override fun share() {
        view.shareDogs(shareList)
    }
}