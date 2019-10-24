package com.github.outerheavenproject.wanstagram.ui

import android.util.Log
import com.github.outerheavenproject.wanstagram.di.ActivityScope
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionSink
import javax.inject.Inject

/**
 * The entity of [MainContract.Presenter] and [DogActionSink] is [MainPresenter].
 */
@ActivityScope
class MainPresenter @Inject constructor(
    private val view: MainContract.View
) : MainContract.Presenter, DogActionSink {
    private val shareList = mutableSetOf<String>()

    override fun start() {
    }

    override fun write(url: String) {
        Log.i("MainPresenter", this.hashCode().toString())
        shareList.add(url)
    }

    override fun share() {
        view.shareDogs(shareList)
    }
}