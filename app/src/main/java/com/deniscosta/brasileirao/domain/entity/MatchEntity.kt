package com.deniscosta.brasileirao.domain.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class MatchEntity(
    val id: Int,
    @Json(name = "time_mandante")
    val homeTeam: String,
    @Json(name = "time_mandante_sigla")
    val homeTeamInitials : String,
    @Json(name = "placar_time_mandante")
    val homeTeamScoredGoals: String,
    @Json(name = "time_mandante_escudo")
    val homeTeamEmblem: String,
    @Json(name = "time_visitante")
    val awayTeam: String,
    @Json(name = "time_visitante_initials")
    val awayTeamInitials: String,
    @Json(name = "placar_time_visitante")
    val awayTeamScoreGoals : String,
    @Json(name = "rodada")
    val round : Int,
    @Json(name = "foiJogado")
    val itWasPlayed : Boolean,
    @Json(name = "local")
    val local : String,
    @Json(name = "data")
    val date : String,
    @Json(name = "horario")
    val hour : String
) : Parcelable