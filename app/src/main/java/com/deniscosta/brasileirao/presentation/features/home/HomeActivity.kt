package com.deniscosta.brasileirao.presentation.features.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.deniscosta.brasileirao.R
import com.deniscosta.brasileirao.domain.entity.RoundEntity
import com.deniscosta.brasileirao.presentation.base.BaseViewModelActivity
import com.deniscosta.brasileirao.presentation.features.home.adapters.MatchAdapter
import com.deniscosta.brasileirao.presentation.features.home.adapters.RoundAdapter
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseViewModelActivity(), RoundAdapter.OnItemClick {

    companion object{
        fun newIntent(context : Context) = Intent(context,HomeActivity::class.java)
    }

    private val homeViewModel : HomeViewModel by viewModel()

    private lateinit var roundAdapter: RoundAdapter
    private lateinit var matchAdapter : MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        initView()

        homeViewModel.bind(::render)
        homeViewModel.listen(::handle)

    }

    private fun initView(){

        roundAdapter = RoundAdapter(mutableListOf(), this)
        matchAdapter = MatchAdapter(mutableListOf())

        rvRounds.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvRounds.adapter = roundAdapter

        rvMatches.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMatches.adapter = matchAdapter

    }

    private fun render(state: HomeState){
        state::loading partTo ::renderLoading
    }

    private fun renderLoading(isLoading : Boolean){

    }

    private fun handle(command : HomeCommand){
        when(command){
            is HomeCommand.GetRoundsSuccessful -> {
                roundAdapter.setNewData(command.rounds)
            }
            is HomeCommand.GetMatchesByRoundSuccessful -> {
                matchAdapter.setNewData(command.matches)
            }
        }
    }

    override fun onRoundClickListener(item: RoundEntity, position: Int) {
        homeViewModel.getMatches(item.round)
    }

}