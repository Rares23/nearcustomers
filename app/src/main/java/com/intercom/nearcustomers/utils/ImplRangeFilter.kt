package com.intercom.nearcustomers.utils

import kotlin.math.*

class ImplRangeFilter : RangeFilter {
    override fun isInRange(
        range: Int,
        firstLat: Double,
        secondLat: Double,
        firstLng: Double,
        secondLng: Double
    ): Boolean {
        val firstLatRad: Double = Math.toRadians(firstLat)
        val secondLatRad: Double = Math.toRadians(secondLat)
        val firstLngRad: Double = Math.toRadians(firstLng)
        val secondLngRad: Double = Math.toRadians(secondLng)

        val sinProd = sin(firstLatRad) * sin(secondLatRad)
        val cosProd = cos(firstLatRad) * cos(secondLatRad) * cos(secondLngRad - firstLngRad)
        val latD = acos(sinProd + cosProd)

        val distanceKm = (3963.0 * latD) * 1.609344
        return distanceKm <= range
    }
}