package com.zeeb.footballleague.adapter

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zeeb.footballleague.helper.dp
import com.zeeb.footballleague.model.FootBallItemModel
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*


class AdapterFootball(val items: List<FootBallItemModel>, val listener: (FootBallItemModel) -> Unit) : RecyclerView.Adapter<AdapterFootball.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemFootballUI().createView(
        AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        val image = itemView.findViewById<ImageView>(ItemFootballUI.league_image)
        val name = itemView.findViewById<TextView>(ItemFootballUI.league_name)

        fun bind(item: FootBallItemModel, listener: (FootBallItemModel) -> Unit) {
            Glide.with(itemView.context)
                .load(item.foto)
                .into(image)

            name.text = item.nama

            itemView.setOnClickListener { listener(item) }
        }
    }
}
class ItemFootballUI : AnkoComponent<ViewGroup> {

    companion object {
        val league_image = 1
        val league_name = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = league_image
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                id = league_name
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)

            }
        }
    }

}