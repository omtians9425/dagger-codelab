package com.github.outerheavenproject.wanstagram.ui.dog

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.outerheavenproject.wanstagram.data.Dog
import com.github.outerheavenproject.wanstagram.data.DogService
import com.github.outerheavenproject.wanstagram.data.Dogs
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

/**
 * DogPresenter depends on DogService and DogContract.View.
 * So Replace these dependency objects with Mock.
 */
@RunWith(AndroidJUnit4::class)
class DogPresenterTest {

    private lateinit var presenter: DogPresenter
    private lateinit var dogService: DogService
    private lateinit var view: TestView

    @Before
    fun setUp() {
        dogService = TestDogService()
        view = TestView()
        presenter = DogPresenter(dogService = dogService)
        presenter.attachView(view)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun start() {
        /*
        DogPresenter#start is suspend function, so use it in a couroutine builder dedicated to testing.
         */
        runBlockingTest {
            presenter.start()
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

private class TestView : DogContract.View {
    var called = 0
    override fun updateDogs(dogs: Dogs) {
        called++
    }
}