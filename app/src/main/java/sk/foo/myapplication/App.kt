package sk.foo.myapplication

import android.app.Application
import android.util.Log
import sk.foo.lib.LibraryParentComponent

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.factory().create(this)
        val libraryComponent = (appComponent as LibraryParentComponent).libraryComponentFactory.create()
        Log.d("Default", "somethingLibrary=${libraryComponent.somethingLibrary}")
        Log.d("Default", "somethingLibrary2=${libraryComponent.somethingLibrary}")
    }
}