package com.deniscosta.brasileirao.presentation.features.home.adapters

import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.deniscosta.brasileirao.R
import com.deniscosta.brasileirao.domain.entity.RoundEntity

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */
class RoundAdapter(
    data : MutableList<RoundEntity>,
    private val listener : OnItemClick
) : BaseQuickAdapter<RoundEntity, BaseViewHolder>(R.layout.layout_round_item, data) {

    override fun convert(helper: BaseViewHolder?, item: RoundEntity?) {

        helper?.getView<LinearLayout>(R.id.roundSelector)
            ?.apply {
                isSelected = item?.selected!!
            }
        helper?.getView<LinearLayout>(R.id.roundSelector)?.setOnClickListener {
            val newData = mutableListOf<RoundEntity>()
            data.forEachIndexed { index, roundEntity ->
                newData.add(roundEntity.copy(selected = index == helper.adapterPosition))
            }
            replaceData(newData)

            listener.onRoundClickListener(item!!, helper.adapterPosition)
        }

        helper?.getView<TextView>(R.id.tvRound)
            ?.apply {
                text = item?.label
                setTextColor(if(item?.selected!!) Color.parseColor("#FFFFFF") else Color.parseColor("#1d3557"))
            }

    }

    interface OnItemClick{
        fun onRoundClickListener(item : RoundEntity, position : Int)
    }

}