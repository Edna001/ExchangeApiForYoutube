package com.hellocompany.apiforyoutube.Response

import com.hellocompany.apiforyoutube.Model.Rates

data class ExchangeResponse(
    val rates: Rates? = null,
    val base: String
)