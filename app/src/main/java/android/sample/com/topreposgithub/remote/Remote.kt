package android.sample.com.topreposgithub.remote

import android.content.ContentValues.TAG
import android.sample.com.topreposgithub.model.Repo
import android.sample.com.topreposgithub.model.RepoResponse
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {
    private var retrofit: Retrofit
    private val api: RepoApi

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(RepoApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.github.com/search/"
        private const val NETWORK_ERROR_MESSAGE = "Network error occurred!"

        private val INSTANCE: Remote = Remote()

        fun getInstance() : Remote {
            return INSTANCE
        }
    }

    fun fetchRepos(topic: String): LiveData<List<Repo>> {
        val call = api.getRepos(topic)
        val data = MutableLiveData<List<Repo>>()

        call.enqueue(object : Callback<RepoResponse> {
            override fun onResponse(call: Call<RepoResponse>, response: Response<RepoResponse>) {
                if (response.body() != null)
                    data.postValue(response.body()!!.repos)
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                Log.e(TAG, NETWORK_ERROR_MESSAGE + t.message)
            }
        })

        return data
    }
}