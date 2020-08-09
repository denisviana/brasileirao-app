package com.deniscosta.brasileirao.presentation.features.home.adapters

import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.deniscosta.brasileirao.R
import com.deniscosta.brasileirao.domain.entity.MatchEntity
import com.deniscosta.brasileirao.presentation.glide.GlideApp
import com.deniscosta.brasileirao.presentation.glide.SvgSoftwareLayerSetter

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class MatchAdapter(
    data : MutableList<MatchEntity>
) : BaseQuickAdapter<MatchEntity, BaseViewHolder>(R.layout.layout_match_item, data) {

    override fun convert(helper: BaseViewHolder?, item: MatchEntity?) {

        helper?.setText(R.id.tvScoreBoard,
            "${item?.homeTeamScoredGoals} : ${item?.awayTeamScoredGoals}")

        helper?.setText(R.id.homeTeam, item?.homeTeam)
        helper?.setText(R.id.awayTeam, item?.awayTeam)

        helper?.setText(R.id.tvGameLocationAndDate,
            "${item?.local} - ${item?.date} - ${item?.hour}")

        val homeTeamEmblemRequestBuilder : RequestBuilder<PictureDrawable> =
            GlideApp.with(mContext)
            .`as`(PictureDrawable::class.java)
            .transition(withCrossFade())
            .listener(SvgSoftwareLayerSetter())

        val awayTeamEmblemRequestBuilder : RequestBuilder<PictureDrawable> =
            GlideApp.with(mContext)
            .`as`(PictureDrawable::class.java)
            .transition(withCrossFade())
            .listener(SvgSoftwareLayerSetter())

        homeTeamEmblemRequestBuilder.load(item?.homeTeamEmblem)
            .into(helper?.getView(R.id.homeTeamEmblem)!!)

        awayTeamEmblemRequestBuilder.load(item?.awayTeamEmblem)
            .into(helper?.getView(R.id.awayTeamEmblem)!!)

    }

}