package com.hilt.demo.di


import com.hilt.demo.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPIService {

    @GET("trending?api_key=g4r6jg0XscoaFouQf2GGlTdTPEMSpm7G&limit=10000")
    suspend fun fetchData(): Response<PostModel>
}