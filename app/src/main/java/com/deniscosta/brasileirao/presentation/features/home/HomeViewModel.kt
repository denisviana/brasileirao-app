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

        command.value = HomeCommand.GetRoundsSuccessful(rounds)
    }

    fun getMatches(round : Int){

        viewModelScope.launch {

            withContext(Dispatchers.Default) {
                try {
                    val result = getMatchesByRoundUseCase(round)
                    withContext(Dispatchers.Main){
                        command.value =
                            HomeCommand.GetMatchesByRoundSuccessful(matches = result.response.toMutableList())
                    }
                } catch (e: Exception) {
                    Timber.e(e)
                }
            }

        }
    }

}

data class HomeState(
    val loading : Boolean = false
)

sealed class HomeCommand{
    data class GetRoundsSuccessful(val rounds : MutableList<RoundEntity>) : HomeCommand()
    data class GetMatchesByRoundSuccessful(val matches : MutableList<MatchEntity>) : HomeCommand()
}