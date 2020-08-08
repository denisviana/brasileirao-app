package com.deniscosta.brasileirao.di

import com.deniscosta.brasileirao.data.repository.MatchRepositoryImpl
import com.deniscosta.brasileirao.domain.repository.MatchRepository
import org.koin.dsl.module

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */

val repositoryModule = module {

    single<MatchRepository> { MatchRepositoryImpl(get()) }

}