package sk.foo.myapplication

import android.content.Context
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
@AppScope
@MergeComponent(AppScope::class)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}

@Module
@ContributesTo(AppScope::class)
object AppAndroidModule {
    fun smethingDifferent(): SomethingDifferent = SomethingDifferent()
}

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class AppScope

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

@Module
@ContributesTo(SubScope::class)
object SubScopedAndroidModule {
    fun dependency(context: Context): Dependency = AndroidDependency(context)
}

@Module
@ContributesTo(SubScope::class)
object SubScopedRegularAndroidLessModule {
    fun foo(): Foo = Foo()
}

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class SubScope