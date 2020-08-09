package com.deniscosta.brasileirao.data.model.remote

import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
@JsonClass(generateAdapter = true)
data class MatchesResponse(
    @Json(name = "response")
    val response : List<MatchEntity>
)