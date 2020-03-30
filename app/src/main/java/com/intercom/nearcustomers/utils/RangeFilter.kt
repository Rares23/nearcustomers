package com.intercom.nearcustomers.utils

interface RangeFilter {
    fun isInRange(range: Int, firstLat: Double, secondLat: Double, firstLng: Double, secondLng: Double) : Boolean
}