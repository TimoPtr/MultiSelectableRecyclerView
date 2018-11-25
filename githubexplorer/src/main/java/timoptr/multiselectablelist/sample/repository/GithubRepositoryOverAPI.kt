package timoptr.multiselectablelist.sample.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import timoptr.multiselectablelist.sample.thirdparty.service.GitHubService
import timoptr.multiselectablelist.sample.viewmodel.GitRepositoryViewModel

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecyclerView with IntelliJ IDEA.
 */
class GithubRepositoryOverAPI(private val subscriber: CompositeDisposable) : GithubRepository {
    private val TAG = GithubRepositoryOverAPI::class.java.simpleName
    private val gitHubService = GitHubService()

    override fun getRepositories(): LiveData<PagedList<GitRepositoryViewModel>> =
            LivePagedListBuilder(object : DataSource.Factory<Int, GitRepositoryViewModel>() {
                override fun create(): DataSource<Int, GitRepositoryViewModel> =
                        object : PageKeyedDataSource<Int, GitRepositoryViewModel>() {
                            override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, GitRepositoryViewModel>) {
                                Log.i(TAG, "loadInitial start")
                                subscriber += gitHubService.getRepositories()
                                        .subscribeOn(Schedulers.io())
                                        .map { it.map { GitRepositoryViewModel(it.id, it.name) } }
                                        .subscribe({
                                            callback.onResult(it, null, it.last().id)
                                        }, {
                                            Log.w(TAG, "load Initial failed", it)
                                        })
                            }

                            override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepositoryViewModel>) {
                                Log.i(TAG, "loadAfter start at ${params.key}")
                                subscriber += gitHubService.getRepositories(params.key)
                                        .subscribeOn(Schedulers.io())
                                        .map { it.map { GitRepositoryViewModel(it.id, it.name) } }
                                        .subscribe({
                                            callback.onResult(it, it.last().id)
                                        }, {
                                            Log.w(TAG, "load Initial failed", it)
                                        })
                            }

                            override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepositoryViewModel>) {

                            }

                        }
            }, PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(100)
                    .setPageSize(50).build()).build()

}