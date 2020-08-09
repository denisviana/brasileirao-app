package com.deniscosta.brasileirao.domain.repository

import com.deniscosta.brasileirao.data.model.remote.MatchesResponse

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
interface MatchRepository {
    suspend fun getMatchesByRound(round : Int) : MatchesResponse
}