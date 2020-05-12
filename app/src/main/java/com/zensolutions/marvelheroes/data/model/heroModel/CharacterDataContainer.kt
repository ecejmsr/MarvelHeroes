package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CharacterDataContainer(val offset: Int?, val limit: Int?, val total: Int?, val count: Int?, val results: List<Character?>?): Parcelable
