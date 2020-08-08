package com.deniscosta.brasileirao.presentation.features.home

import com.deniscosta.brasileirao.domain.entity.RoundEntity
import com.deniscosta.brasileirao.presentation.base.BaseViewModel

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class HomeViewModel : BaseViewModel<HomeState, HomeCommand>() {

    init {
        val rounds = mutableListOf<RoundEntity>()
        for (i in 1..38){
            rounds.add(
                RoundEntity(
                    label = "${i}ª Rodada",
                    selected = i == 1
                )
            )
        }

        command.value = HomeCommand.GetRoundsSuccessful(rounds)
    }

}

data class HomeState(
    val loading : Boolean = false
)

sealed class HomeCommand{
    data class GetRoundsSuccessful(val rounds : MutableList<RoundEntity>) : HomeCommand()
}