package sk.foo.lib2

import com.squareup.anvil.annotations.ContributesTo
import sk.foo.scopes.LibraryScope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 9. 8. 2021.
 */
class SomethingLibrary2 {
}

@ContributesTo(LibraryScope::class)
interface FooLibaryComponent {
    val somethingLibrary2: SomethingLibrary2
}