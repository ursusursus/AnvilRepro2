package sk.foo.myapplication

import android.content.Context
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import sk.foo.lib.LibraryComponent
import sk.foo.scopes.AppScope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
@AppScope
@MergeComponent(AppScope::class)
interface AppComponent {
    val libraryComponentFactory: LibraryComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}

@Module
@ContributesTo(AppScope::class)
object AndroidAppModule {
    @JvmStatic
    @Provides
    fun somethingAppScoped(context: Context): SomethingAppScoped = AndroidSomethingAppScoped(context)
}