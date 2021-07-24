package sk.foo.myapplication

import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Assert
import org.junit.Test

class DaggerTest {
    @Test
    fun fooTest() {
        val appComponent = DaggerTestAppComponent.factory().create()

        val somethingDifferent = appComponent.somethingAppScoped
        println("SomethingAppScoped=$somethingDifferent")

        Assert.assertTrue(true)
    }
}

@AppScope
@MergeComponent(AppScope::class)
interface TestAppComponent {

    val somethingAppScoped: SomethingAppScoped

    @Component.Factory
    interface Factory {
        fun create(): TestAppComponent
    }
}

@Module
@ContributesTo(AppScope::class, replaces = [AndroidAppModule::class])
object FakeAppModule {
    @JvmStatic
    @Provides
    fun somethingDifferent(): SomethingAppScoped = FakeSomethingAppScoped()
}

class FakeSomethingAppScoped : SomethingAppScoped