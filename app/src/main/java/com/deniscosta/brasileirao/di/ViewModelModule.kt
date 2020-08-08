package com.deniscosta.brasileirao.di

import com.deniscosta.brasileirao.presentation.features.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Denis Costa on 07/08/20.
 */

val viewModelModule = module {

    viewModel{HomeViewModel()}
}