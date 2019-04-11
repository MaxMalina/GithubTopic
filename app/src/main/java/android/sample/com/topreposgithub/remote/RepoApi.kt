package android.sample.com.topreposgithub.remote

import android.sample.com.topreposgithub.model.RepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RepoApi {

    @Headers("Accept: application/vnd.github.mercy-preview+json")
    @GET("repositories")
    fun getRepos(@Query("q") topic: String): Call<RepoResponse>
}