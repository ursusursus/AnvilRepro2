package sk.foo.lib2

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
object LibraryModule2 {
    @Provides
    @JvmStatic
    @LibraryScope
    fun somethingLibrary2(): SomethingLibrary2 = SomethingLibrary2()
}