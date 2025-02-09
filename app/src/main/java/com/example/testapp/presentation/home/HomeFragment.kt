package com.example.testapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.adapters.HomeAdapter
import com.example.testapp.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        progressBar = view.findViewById(R.id.progressBar)

        observeState()

        homeViewModel.fetchHomeData()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.homeState.collect { state ->
                    if (state.data.isNotEmpty()) {
                        adapter = HomeAdapter(state.data) {
                            // Handle Item click
                            val intent = Intent(requireContext(), DetailActivity::class.java)
                            intent.putExtra("image", it.card.image?.url)
                            intent.putExtra("title", it.card.title?.value)
                            intent.putExtra("description", it.card.description?.value)
                            startActivity(intent)
                        }
                        recyclerView.adapter = adapter
                    }
                }
            }
        }
    }
}
