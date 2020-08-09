package com.deniscosta.brasileirao.base

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.koin.test.KoinTest
import java.io.File

/**
 * Created by Denis Costa on 09/08/20.
 * denisvcosta@gmail.com
 */
open class BaseUT : KoinTest {

    private lateinit var mockServerInstance: MockWebServer

    private var shouldStart = false

    @Before
    open fun setUp() {
        shouldStart = true;
        startMockServer()
    }

    fun mockNetworkResponseWithFileContent(fileName: String, responseCode: Int) =
        mockServerInstance.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    private fun startMockServer() {
        if (shouldStart) {
            mockServerInstance = MockWebServer()
            mockServerInstance.start()
        }
    }

    fun getJson(path: String): String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    fun getMockWebServerUrl() = mockServerInstance.url("/").toString()

    private fun stopMockServer() {
        if (shouldStart) {
            mockServerInstance.shutdown()
        }
    }

    @After
    open fun tearDown() {
        //Stop Mock server
        stopMockServer()
        //Stop Koin as well

    }
}