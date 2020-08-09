package com.deniscosta.brasileirao.data.data_source.match.remote

import com.deniscosta.brasileirao.data.model.remote.MatchesResponse

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
interface MatchRemoteDataSource {

    suspend fun getMatchesByRound(round : Int) : MatchesResponse

}