package com.deniscosta.brasileirao.di

import com.deniscosta.brasileirao.domain.use_case.GetMatchesByRoundUseCase
import org.koin.dsl.module

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */

val useCaseModule = module {

    factory { GetMatchesByRoundUseCase(get()) }

}