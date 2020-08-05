package com.jason.movietvcatalog.data.source.remote.response

data class CreditResponse(
    var id: Int,
    var cast: List<ActorResponse>
)