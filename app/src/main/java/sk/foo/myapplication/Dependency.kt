package sk.foo.myapplication

import android.content.Context

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
interface Dependency

class AndroidDependency(context: Context) : Dependency

class FakeDependency : Dependency

class SomethingDifferent

class Foo