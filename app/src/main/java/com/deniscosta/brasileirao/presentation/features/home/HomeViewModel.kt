package com.deniscosta.brasileirao.presentation.features.home

import androidx.lifecycle.viewModelScope
import com.deniscosta.brasileirao.data.model.remote.MatchesResponse
import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.deniscosta.brasileirao.domain.entity.RoundEntity
import com.deniscosta.brasileirao.domain.use_case.GetMatchesByRoundUseCase
import com.deniscosta.brasileirao.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class HomeViewModel(
    private val getMatchesByRoundUseCase: GetMatchesByRoundUseCase
) : BaseViewModel<HomeState, HomeCommand>() {

    init {
        newState(HomeState())
        val rounds = mutableListOf<RoundEntity>()
        for (i in 1..38){
            rounds.add(
                RoundEntity(
                    round = i,
                    label = "${i}ª Rodada",
                    selected = i == 1
                )
            )
        }

        getMatches(round = 1)

    }

    fun getMatches(round : Int){

        newState{ copy( loading = true)}

        viewModelScope.launch {

            withContext(Dispatchers.Main) {
                try {
                    val result = getMatchesByRoundUseCase(round)
                    newState{ copy(loading = false, matches = result) }
                } catch (e: Exception) {
                    newState{ copy( loading = false)}
                    Timber.e(e)
                }
            }
        }
    }

}

data class HomeState(
    val loading : Boolean = false,
    val rounds : List<RoundEntity> = emptyList(),
    val matches : List<MatchEntity> = emptyList()
)

sealed class HomeCommand