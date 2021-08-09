package sk.foo.lib

import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent
import sk.foo.scopes.LibraryScope

@LibraryScope
@MergeSubcomponent(LibraryScope::class)
interface LibraryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LibraryComponent
    }
}