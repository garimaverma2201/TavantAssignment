package com.app.tanvant.api

import com.app.tanvant.model.ProductResponse
import com.app.tanvant.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    suspend fun getFakeProductList(): List<ProductResponse>
}