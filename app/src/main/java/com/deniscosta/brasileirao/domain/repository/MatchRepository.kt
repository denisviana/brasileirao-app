package com.deniscosta.brasileirao.domain.repository

import com.deniscosta.brasileirao.domain.entity.MatchEntity

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
interface MatchRepository {
    suspend fun getMatchesByRound(round : Int) : List<MatchEntity>
}