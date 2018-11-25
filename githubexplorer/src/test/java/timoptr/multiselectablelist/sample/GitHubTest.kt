package timoptr.multiselectablelist.sample

import org.junit.Test
import timoptr.multiselectablelist.sample.thirdparty.service.GitHubService

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecyclerView with IntelliJ IDEA.
 */
class GitHubTest {

    @Test
    fun getRepositories() {
        val gitHubService = GitHubService()
        gitHubService.getRepositories().doOnSuccess { println(it) }.test().await().assertNoErrors()
    }
}