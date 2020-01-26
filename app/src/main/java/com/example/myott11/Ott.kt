package com.example.myott11

import android.widget.ImageView

data class Ott(
    var imageView: ImageView,
    var index: Int =1,
    var letter:String="א",
    var wight:Int=200,
    var hight:Int=200,
    var marginLeft:Int=0,
    var marginTop:Int=0,
    var marginRight:Int=0,
    var marginBottom:Int=0
) {
}