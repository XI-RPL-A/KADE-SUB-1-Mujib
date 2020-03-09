package com.zeeb.footballleague.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.zeeb.footballleague.R
import com.zeeb.footballleague.adapter.AdapterFootball
import com.zeeb.footballleague.model.FootBallItemModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity() {

    companion object {
        const val PARCELABLE_ITEM_FOOTBALL = "item"
    }

    var footBallItemModel: MutableList<FootBallItemModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadDataFootball()

        verticalLayout {
            lparams(matchParent, wrapContent)

            recyclerView {
                layoutManager = GridLayoutManager(context, 2)
                addItemDecoration(DividerItemDecoration(context, 1))
                adapter = AdapterFootball(footBallItemModel) {
                    startActivity<DetailActivity>(PARCELABLE_ITEM_FOOTBALL to it)
                }
            }
        }

    }

    private fun loadDataFootball() {
        val foto = resources.obtainTypedArray(R.array.daftar_foto)
        val nama = resources.getStringArray(R.array.daftar_club)
        val deskripsi = resources.getStringArray(R.array.detail_club)

        footBallItemModel.clear()

        for (i in nama.indices) {
            footBallItemModel.add(
                FootBallItemModel(
                    foto.getResourceId(i, 0),
                    nama[i],
                    deskripsi[i]
                )
            )
        }

        foto.recycle()
    }
}
