package com.sidrakotlin.internetdata.network

import com.squareup.moshi.Json

data class Photos(val id:String,
                  @Json(name="img_src") val imgSrc: String

                  )