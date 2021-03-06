package com.taein.paging3test.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrena.commerce.paging3.data.Injection
import com.taein.campustalkRecommendChatRoomPaging3Test.R
import com.taein.campustalkRecommendChatRoomPaging3Test.databinding.FragmentMovieListBinding
import com.taein.campustalkRecommendChatRoomPaging3Test.view.RecommendedChatRoomPagingAdapter
import com.taein.paging3test.view.viewmodel.GetReplysRxViewModel
import io.reactivex.disposables.CompositeDisposable

class MovieRxFragment : Fragment() {
    private val mDisposable = CompositeDisposable()

    private lateinit var mBinding: FragmentMovieListBinding
    private lateinit var mViewModel: GetReplysRxViewModel
    private lateinit var mAdapter: RecommendedChatRoomPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMovieListBinding.inflate(inflater, container, false)

        val view = mBinding.root

        activity?.title = getString(R.string.rx_with_paging_source)

        mViewModel = ViewModelProvider(this, Injection.provideRxViewModel()).get(
            GetReplysRxViewModel::class.java)

        mAdapter = RecommendedChatRoomPagingAdapter()

        mBinding.list.layoutManager = LinearLayoutManager(view.context)
        mBinding.list.adapter = mAdapter
        mBinding.list.adapter = mAdapter.withLoadStateFooter(
            footer = LoadingGridStateAdapter()
        )
        mAdapter.addLoadStateListener { loadState ->
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                AlertDialog.Builder(view.context)
                    .setTitle(R.string.error)
                    .setMessage(it.error.localizedMessage)
                    .setNegativeButton(R.string.cancel) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.retry) { _, _ ->
                        mAdapter.retry()
                    }
                    .show()
            }
        }

        /*mDisposable.add(mViewModel.getFavoriteMovies().subscribe {
            mAdapter.submitData(lifecycle, it)
        })*/

        mDisposable.add(mViewModel.getReplys().subscribe {
            mAdapter.submitData(lifecycle, it)
        })

        return view
    }

    override fun onDestroyView() {
        mDisposable.dispose()

        super.onDestroyView()
    }
}