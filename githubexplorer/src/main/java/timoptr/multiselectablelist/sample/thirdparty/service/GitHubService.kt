package timoptr.multiselectablelist.sample.thirdparty.service

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import timoptr.multiselectablelist.sample.thirdparty.model.GitRepository
import java.lang.Exception

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecyclerView with IntelliJ IDEA.
 */
class GitHubService {
    private val gitHubAPI: GitHubAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        gitHubAPI = retrofit.create()
    }

    fun getRepositories(startAt: Int = 0): Single<List<GitRepository>> =
            gitHubAPI.getRepositories(startAt)
                    .map {
                        if (it.isSuccessful) {
                            it.body() ?: listOf()
                        } else {
                            throw GitHubException(it.code(), it.errorBody()?.string() ?: "")
                        }
                    }
}

class GitHubException(val code: Int, override val message: String) : Exception()