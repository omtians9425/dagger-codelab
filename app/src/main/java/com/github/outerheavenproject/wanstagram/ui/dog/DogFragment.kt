package com.github.outerheavenproject.wanstagram.ui.dog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.outerheavenproject.wanstagram.App
import com.github.outerheavenproject.wanstagram.R
import com.github.outerheavenproject.wanstagram.data.Dogs
import com.github.outerheavenproject.wanstagram.ui.AppNavigatorImpl
import com.github.outerheavenproject.wanstagram.ui.DogAdapter
import com.github.outerheavenproject.wanstagram.ui.MainActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.launch
import javax.inject.Inject

class DogFragment : Fragment(),
    DogContract.View {

    @Inject
    lateinit var presenter: DogPresenter

    @Inject
    lateinit var dogAdapter: DogAdapter

    override fun onAttach(context: Context) {
//        (requireActivity().application as App).appComponent.inject(this)
//        (requireActivity() as MainActivity).subComponent.inject(this)
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(context, 2)
        recycler.adapter = dogAdapter

        presenter.attachView(this)

        lifecycleScope.launch {
            presenter.start()
        }
    }

    override fun updateDogs(dogs: Dogs) {
        dogAdapter.submitList(dogs.urls)
    }
}
