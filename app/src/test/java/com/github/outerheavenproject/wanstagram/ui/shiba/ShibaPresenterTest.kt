package com.github.outerheavenproject.wanstagram.ui.shiba

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.outerheavenproject.wanstagram.data.Dog
import com.github.outerheavenproject.wanstagram.data.DogService
import com.github.outerheavenproject.wanstagram.data.Dogs
import com.github.outerheavenproject.wanstagram.ui.dog.DogContract
import com.github.outerheavenproject.wanstagram.ui.dog.DogPresenter
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShibaPresenterTest {
    private lateinit var dogService: DogService
    private lateinit var dogPresenter: DogPresenter
    private lateinit var view: TestView



    @Before
    fun setUp() {
        dogService = TestDogService()
        view = TestView()
        dogPresenter = DogPresenter(dogService = dogService)
        dogPresenter.attachView(view)
    }

    @Test
    fun start() {
        runBlockingTest {
            dogPresenter.start()
        }
        Truth.assertThat(view.called).isEqualTo(1)
    }
}

private class TestDogService : DogService {
    override suspend fun getDog(): Dog {
        return Dog(url = "1", status = "success")
    }

    override suspend fun getDogs(limit: Int): Dogs {
        return Dogs(urls = listOf("1"), status = "success")
    }

    override suspend fun getBleed(bleed: String, limit: Int): Dogs {
        return Dogs(urls = listOf("1"), status = "success")
    }
}

private class TestView: DogContract.View {
    var called = 0
    override fun updateDogs(dogs: Dogs) {
        called++
    }
}