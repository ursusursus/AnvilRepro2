package sk.foo.myapplication

import android.app.Application
import android.util.Log
import sk.foo.lib2.FooLibaryComponent

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("Default", "App # onCreate")
        val appComponent = DaggerAppComponent.factory().create(this)
        val libraryComponent = (appComponent.libraryComponentFactory.create() as FooLibaryComponent)
        Log.d("Default", "somethingLibrary2=${libraryComponent.somethingLibrary2}")
    }
}