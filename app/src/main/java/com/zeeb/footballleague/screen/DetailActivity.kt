package com.zeeb.footballleague.screen

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.zeeb.footballleague.model.FootBallItemModel
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<FootBallItemModel>(MainActivity.PARCELABLE_ITEM_FOOTBALL)
        DetailUI(item!!).setContentView(this)
    }

    class DetailUI(val item: FootBallItemModel) : AnkoComponent<DetailActivity> {
        companion object {
            const val foto = 1
            const val nama = 2
            const val idView = 4
        }

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                view {
                    id = idView
                    setBackgroundColor(Color.rgb(126, 203, 238))
                }.lparams(matchParent, dip(150))

                imageView {
                    id = foto
                    Glide.with(this)
                        .load(item.foto)
                        .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = nama
                    text = item.nama
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(foto)
                    centerHorizontally()
                }

                textView {
                    padding = dip(16)
                    text = item.deskripsi
                }.lparams {
                    below(nama)
                }
            }
        }


    }
}

