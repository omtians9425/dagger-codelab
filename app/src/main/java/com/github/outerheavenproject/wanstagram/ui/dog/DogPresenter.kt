package com.github.outerheavenproject.wanstagram.ui.dog

import com.github.outerheavenproject.wanstagram.data.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * This annotation specifies
 * 1. Implemented instance of DogService is injected to This Object (as long as instance is resolved in the object graph).
 * 2. DogPresenter is registered in the object graph.
 */
class DogPresenter @Inject constructor(
//    private val dogService: DogService
    private val repository: DogRepository
) : DogContract.Presenter {
    private lateinit var view: DogContract.View

    fun attachView(view: DogContract.View) {
        this.view = view
    }

    override suspend fun start() {
//        Log.i("DogPresenter", dogService.toString()) //The same instance of ShibaPresenter
//        val dogs = dogService.getDogs(limit = 20)
        val dogs = repository.findAll()
        withContext(Dispatchers.Main) {
            view.updateDogs(dogs)
        }
    }
}
