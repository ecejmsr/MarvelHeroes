package com.zensolutions.marvelheroes.util


object MarvelHeroesImageUtil {

    val imageOptions = hashMapOf<String, String>(
        "small" to "standard_small",
        "medium" to "standard_medium",
        "large" to "standard_large",
        "xlarge" to "standard_xlarge",
        "xxlarge" to "standard_fantastic",
        "xxxlarge" to "standard_amazing",
        "full" to "detail"
    )

    fun imgUtil(imgUrl: String?, imgSize: String, imgType: String?): String? {
        return if (imageOptions.containsKey(imgSize)) {
            imgUrl + "/" + imageOptions.getValue(imgSize) + "." + imgType
        } else {
            "IMAGE_NOT_FOUND"
        }
    }

}
