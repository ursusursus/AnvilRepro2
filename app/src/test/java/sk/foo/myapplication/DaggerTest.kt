package sk.foo.myapplication

import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component
import dagger.Module
import org.junit.Assert
import org.junit.Test

class DaggerTest {
    @Test
    fun fooTest() {
        val appComponent = DaggerTestAppComponent.factory().create()
        val dependency = appComponent.dependency
        Assert.assertTrue(true)
    }
}

@AppScope
@MergeComponent(AppScope::class, exclude = [AppAndroidModule::class])
interface TestAppComponent {
    val dependency: Dependency

    @Component.Factory
    interface Factory {
        fun create(): TestAppComponent
    }
}

@Module
@ContributesTo(AppScope::class)
object FakeAppModule {
    fun dependency(): Dependency = FakeDependency()
}