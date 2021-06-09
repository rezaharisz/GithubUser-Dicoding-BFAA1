package com.rezaharis.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        var username:String = "",
        var name:String = "",
        var avatar: Int = 0,
        var location:String = "",
        var repository:String = "",
        var company:String = "",
        var followers:String = "",
        var following:String = ""
):Parcelable