package com.zensolutions.marvelheroes.data.network.retrofit

import java.math.BigInteger
import java.security.MessageDigest

object MarvelTSProvider {
    var pinString = ""
    var ts = ""

    //TODO Jose we need to pass this more secretively API Keys
    fun setTS(): String {
        ts = System.currentTimeMillis().toString()
        pinString = calculatePin(ts, "406402f980734048e838275c3ee9aabb")
        return ts
    }

    private fun setLongDigestString(ts: String, key: String): ByteArray {
        return (ts + "1713807e7294154ffeebf5a31e7ba21bc8553617" + key).toByteArray(Charsets.UTF_8)
    }

    fun calculatePin(ts: String, key: String): String {
        return String.format(
            "%032x", BigInteger(
                1, MessageDigest.getInstance("MD5").digest(
                    setLongDigestString(ts, key)
                )
            )
        )
    }

    fun setPin(): String{
        return pinString
    }
}
