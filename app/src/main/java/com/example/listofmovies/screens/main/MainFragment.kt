package com.example.listofmovies.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.listofmovies.MAIN
import com.example.listofmovies.R
import com.example.listofmovies.databinding.FragmentMainBinding
import com.example.listofmovies.model.MovieItemModel


class MainFragment : Fragment() {
    private  var mBinding:  FragmentMainBinding?=null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        viewModel.getMovies()
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.results)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object {
        fun clickMovie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }
}