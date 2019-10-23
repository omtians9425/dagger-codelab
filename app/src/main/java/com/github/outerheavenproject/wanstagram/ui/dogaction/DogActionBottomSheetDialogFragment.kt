package com.github.outerheavenproject.wanstagram.ui.dogaction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.github.outerheavenproject.wanstagram.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.AndroidInjection
import javax.inject.Inject

class DogActionBottomSheetDialogFragment : BottomSheetDialogFragment(), DogActionBottomSheetContract.View {

    companion object {
        const val TAG = "DogActionBottomSheetDialogFragment"
        private const val URL_KEY = "url"

        fun newInstance(url: String) =
            DogActionBottomSheetDialogFragment().apply { arguments = bundleOf(URL_KEY to url) }
    }

    @Inject
    lateinit var presenter: DogActionBottomSheetContract.Presenter

    private val url: String by lazy {
        requireArguments().getString(URL_KEY) ?: throw  IllegalArgumentException()
    }

    override fun onAttach(context: Context) {
//        AndroidInjection.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LayoutInflater.from(requireContext())
            .inflate(
                R.layout.dog_action_bottom_sheet_dialog_fragment,
                container, false
            )
            .also {
                it.setOnClickListener {
                    presenter.share()
                    dismiss()
                }
            }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start(url)
    }
}