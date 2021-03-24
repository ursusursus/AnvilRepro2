package sk.foo.myapplication

import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import org.junit.Assert
import org.junit.Test

class DaggerTest {
    @Test
    fun fooTest() {
        val appComponent = DaggerTestAppComponent.factory().create()
        val subScopedComponent = (appComponent as TestSubScopedComponent.ParentComponent).testSubScopedComponentFactory.create()
        val dependency = subScopedComponent.dependency

        println("dep=$dependency")
        Assert.assertTrue(true)
    }
}

@AppScope
@MergeComponent(AppScope::class)
interface TestAppComponent {

    @Component.Factory
    interface Factory {
        fun create(): TestAppComponent
    }
}

@SubScope
@MergeSubcomponent(SubScope::class, exclude = [FakeSubScopeModule::class])
interface TestSubScopedComponent {
    val dependency: Dependency

    @ContributesTo(AppScope::class)
    interface ParentComponent {
        val testSubScopedComponentFactory: Factory
    }

    @Subcomponent.Factory
    interface Factory {
        fun create(): TestSubScopedComponent
    }
}

@Module
@ContributesTo(SubScope::class)
object FakeSubScopeModule {
    @Provides
    @JvmStatic
    fun dependency(): Dependency = FakeDependency()
}