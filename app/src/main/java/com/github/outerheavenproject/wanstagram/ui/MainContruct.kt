package com.github.outerheavenproject.wanstagram.ui

interface MainContruct {
    interface View {
        fun shareDogs(dogs: Set<String>)
    }

    interface Presenter {
        fun start()
        fun share()
    }
}