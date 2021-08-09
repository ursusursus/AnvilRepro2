package sk.foo.lib

import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent
import sk.foo.scopes.AppScope
import sk.foo.scopes.LibraryScope

@ContributesTo(AppScope::class)
interface LibraryParentComponent {
    val libraryComponentFactory: LibraryComponent.Factory
}

@LibraryScope
@MergeSubcomponent(LibraryScope::class)
interface LibraryComponent {
    val somethingLibrary: SomethingLibrary

    @Subcomponent.Factory
    interface Factory {
        fun create(): LibraryComponent
    }
}