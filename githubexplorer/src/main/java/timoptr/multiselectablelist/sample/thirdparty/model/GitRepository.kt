package timoptr.multiselectablelist.sample.thirdparty.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Nibeaudeau Timothy <timothy.nibeaudeau@gmail.com>
 * @version 0.1
 * on 25/11/2018 for MultiSelectableRecyclerView with IntelliJ IDEA.
 */

data class GitRepository(
        val id: Int,
        val name: String,
        val private: Boolean = false,
        val owner: Owner,
        @SerializedName("html_url") val url: String) : Serializable {

    data class Owner(val id: Int, val login: String)
}