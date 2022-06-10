package com.polar502.posgt.orders

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Orders(val name: String? = null, val date: String? = null, val price: String? = null, val description: String? = null, val url: String? = null, @Exclude val key: String? = null)