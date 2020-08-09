package com.deniscosta.brasileirao.domain.use_case

import com.deniscosta.brasileirao.data.model.remote.MatchesResponse
import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.deniscosta.brasileirao.domain.repository.MatchRepository

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class GetMatchesByRoundUseCase(
    private val matchRepository: MatchRepository
) {

    suspend operator fun invoke(round: Int) : MatchesResponse {
        return matchRepository.getMatchesByRound(round)
    }

}