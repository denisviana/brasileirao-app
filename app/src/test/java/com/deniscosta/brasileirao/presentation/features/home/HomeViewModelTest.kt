package com.deniscosta.brasileirao.presentation.features.home

import androidx.lifecycle.Observer
import com.deniscosta.brasileirao.base.BaseUT
import com.deniscosta.brasileirao.data.model.remote.MatchesResponse
import com.deniscosta.brasileirao.di.appModules
import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.deniscosta.brasileirao.domain.use_case.GetMatchesByRoundUseCase
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Denis Costa on 09/08/20.
 * denisvcosta@gmail.com
 */
@RunWith(JUnit4::class)
class HomeViewModelTest : BaseUT(){

    @Mock
    lateinit var getMatchesByRoundUseCase: GetMatchesByRoundUseCase

    @Mock
    lateinit var mockLiveDataObserver: Observer<HomeCommand>

    @Mock
    lateinit var homeViewModel: HomeViewModel

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun start() {
        super.setUp()
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.initMocks(this)
        startKoin{ modules(appModules) }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `when getMatches is called, and getMatchesByRoundUseCase works with success, then command live data should be updated with GetMatchesByRoundSuccessful`() = runBlockingTest {
        val matchesResponse = MatchesResponse(response = mutableListOf())
        val round = 1

        launch {
            whenever(getMatchesByRoundUseCase.invoke(round)).thenReturn(matchesResponse)
        }

        homeViewModel.getMatches(round)

        assert(homeViewModel.command.value is HomeCommand.GetMatchesByRoundSuccessful)

    }
}