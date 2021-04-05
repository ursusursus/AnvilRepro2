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
        val subScopedComponent = (appComponent as TestSubScopedComponent.ParentComponent)
            .testSubScopedComponentFactory.create()

        val dependency = subScopedComponent.dependency
        println("dep=$dependency")

        val foo = subScopedComponent.foo
        println("foo=$foo")

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
@MergeSubcomponent(SubScope::class, exclude = [SubScopedAndroidModule::class])
interface TestSubScopedComponent {
    val dependency: Dependency
    val foo: Foo

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