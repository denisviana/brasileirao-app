package com.deniscosta.brasileirao.data.repository

import com.deniscosta.brasileirao.data.data_source.match.remote.MatchRemoteDataSource
import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.deniscosta.brasileirao.domain.repository.MatchRepository

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class MatchRepositoryImpl(
    private val remoteDataSource: MatchRemoteDataSource
) : MatchRepository {


    override suspend fun getMatchesByRound(round: Int): List<MatchEntity> =
        remoteDataSource.getMatchesByRound(round)

}