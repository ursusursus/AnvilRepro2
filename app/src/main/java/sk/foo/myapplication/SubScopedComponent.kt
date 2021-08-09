package sk.foo.myapplication

import android.content.Context
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import sk.foo.scopes.AppScope
import sk.foo.scopes.SubScope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 25. 7. 2021.
 */
@SubScope
@MergeSubcomponent(SubScope::class)
interface SubScopedComponent {

    @ContributesTo(AppScope::class)
    interface ParentComponent {
        val subScopedComponentFactory: Factory
    }

    @Subcomponent.Factory
    interface Factory {
        fun create(): SubScopedComponent
    }
}

@ContributesTo(SubScope::class)
interface PartialSubScopedComponent {
    val dependency: SomethingSubScoped
}

@Module
@ContributesTo(SubScope::class)
object AndroidSubScopedModule {
    @JvmStatic
    @Provides
    fun somethingSubScoped(context: Context): SomethingSubScoped = AndroidSomethingSubScoped(context)
}