package com.deniscosta.brasileirao.presentation.features.home.adapters

import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.deniscosta.brasileirao.R
import com.deniscosta.brasileirao.domain.entity.MatchEntity

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

        Glide.with(mContext)
            .asDrawable()
            .load(item?.homeTeamEmblem)
            .into(helper?.getView(R.id.homeTeamEmblem)!!)

        Glide.with(mContext)
            .asDrawable()
            .load(item?.awayTeamEmblem)
            .into(helper?.getView(R.id.homeTeamEmblem)!!)
    }

}