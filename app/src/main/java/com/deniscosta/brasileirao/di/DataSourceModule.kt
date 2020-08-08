package com.deniscosta.brasileirao.di

import com.deniscosta.brasileirao.data.data_source.match.remote.MatchRemoteDataSource
import com.deniscosta.brasileirao.data.data_source.match.remote.MatchRemoteDataSourceImpl
import org.koin.dsl.module

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */

val dataSourceModule = module {

    factory<MatchRemoteDataSource> { MatchRemoteDataSourceImpl(get()) }

}
