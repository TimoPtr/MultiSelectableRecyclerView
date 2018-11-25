package timoptr.multiselectablelist.sample.thirdparty.service

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import timoptr.multiselectablelist.sample.thirdparty.model.GitRepository

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecyclerView with IntelliJ IDEA.
 */
internal interface GitHubAPI {

    @GET("repositories")
    fun getRepositories(@Query("since") since: Int): Single<Response<List<GitRepository>>>
}