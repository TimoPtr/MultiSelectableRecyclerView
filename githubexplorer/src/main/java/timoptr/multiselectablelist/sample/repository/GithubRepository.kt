package timoptr.multiselectablelist.sample.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import timoptr.multiselectablelist.sample.viewmodel.GitRepositoryViewModel

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
interface GithubRepository {
    fun getRepositories(): LiveData<PagedList<GitRepositoryViewModel>>
}