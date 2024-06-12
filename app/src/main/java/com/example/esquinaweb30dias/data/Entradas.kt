package com.example.esquinaweb30dias.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.esquinaweb30dias.R

data class Entradas(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val content: Int,
    @DrawableRes val image: Int
)

val entradas = listOf(
    Entradas(1, R.string.title_1, R.string.content_1, R.drawable.ydray),
    Entradas(2, R.string.title_2, R.string.content_2, R.drawable.pngegg),
    Entradas(3, R.string.title_3, R.string.content_3, R.drawable.delta_emulator),
    Entradas(4, R.string.title_4, R.string.content_4, R.drawable.tinywow),
    Entradas(5, R.string.title_5, R.string.content_5, R.drawable.vanitas),
    Entradas(6, R.string.title_6, R.string.content_6, R.drawable.tower_of_god),
    Entradas(7, R.string.title_7, R.string.content_7, R.drawable.conuter_strike_2),
    Entradas(8, R.string.title_8, R.string.content_8, R.drawable.eliminardevoz),
    Entradas(9, R.string.title_9, R.string.content_9, R.drawable.itch_io),
    Entradas(10, R.string.title_10, R.string.content_10, R.drawable.powtoon),
    Entradas(11, R.string.title_11, R.string.content_11, R.drawable.svgrepo),
    Entradas(12, R.string.title_12, R.string.content_12, R.drawable.rec_cloud),
    Entradas(13, R.string.title_13, R.string.content_13, R.drawable.hells_paradise),
    Entradas(14, R.string.title_14, R.string.content_14, R.drawable.drawio),
    Entradas(15, R.string.title_15, R.string.content_15, R.drawable.cam_scanner)
)
