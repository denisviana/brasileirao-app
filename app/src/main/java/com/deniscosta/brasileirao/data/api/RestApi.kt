package com.deniscosta.brasileirao.data.api

import com.deniscosta.brasileirao.data.model.remote.MatchesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
interface RestApi {

    @GET("getMatchesByRound")
    suspend fun getMatchesByRound(@Query("round") round: Int) : MatchesResponse

}