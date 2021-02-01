package com.hilt.demo.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hilt.demo.R
import com.hilt.demo.viewmodel.GiphyViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.hilt.demo.util.replaceFragmentWithNoHistory
import kotlinx.android.synthetic.main.emp_fragment_main.progressBar
import kotlinx.android.synthetic.main.emp_fragment_main.recyclerView
import kotlinx.android.synthetic.main.emp_fragment_swipe_main.*

@AndroidEntryPoint
class GhiphySwipeFragment : Fragment() {


    private val mainViewModel: GiphyViewModel by viewModels()
    private var userListView: View? = null
    var mContainerId: Int = -1
    private var postSwipeAdapter: GiphySwipeAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()

        /*For swiping features only*/
        swipe_layout.setOnRefreshListener {
            observeViewModel()
            swipe_layout.isRefreshing = false
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userListView = inflater.inflate(R.layout.emp_fragment_swipe_main, container, false)
        mContainerId = container?.id ?: -1
        return userListView
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.fetchEmpInfo()
    }

    private fun observeViewModel() {
        mainViewModel.fetchUsersLiveData().observe(viewLifecycleOwner, Observer {
            it?.let {
                println("Response From Network :::: $it")
                postSwipeAdapter?.submitList(it)
            }
        })


        mainViewModel.fetchLoadStatus().observe(viewLifecycleOwner, Observer {
            if (!it) {
                println(it)
                progressBar.visibility = View.GONE
            }
        })

        mainViewModel.fetchError().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (!TextUtils.isEmpty(it)) {
                    Toast.makeText(context, "$it", Toast.LENGTH_LONG).show()
                }

            }
        })
    }

    private fun initAdapter() {
        postSwipeAdapter = GiphySwipeAdapter()
        recyclerView.apply {
//            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = postSwipeAdapter

        }



    }
}
