package sk.foo.lib

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import sk.foo.scopes.LibraryScope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 9. 8. 2021.
 */
@Module
@ContributesTo(LibraryScope::class)
object LibraryModule {
    @Provides
    @JvmStatic
    @LibraryScope
    fun somethingLibrary(): SomethingLibrary = SomethingLibrary()
}