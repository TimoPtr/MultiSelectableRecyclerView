package timoptr.multiselectablelist.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timoptr.multiselectablelist.sample.repository.GithubRepository

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 1.0
 * on 24/11/2018 for MultiSelectableRecycleListView with IntelliJ IDEA.
 */
class DemoViewModel(githubRepository: GithubRepository) : ViewModel() {

    class Factory(private val githubRepository: GithubRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = DemoViewModel(githubRepository) as T
    }

    val repositories = githubRepository.getRepositories()
}