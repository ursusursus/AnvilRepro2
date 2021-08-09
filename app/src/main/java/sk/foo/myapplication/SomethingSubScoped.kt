package sk.foo.myapplication

import android.content.Context

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
interface SomethingAppScoped

class AndroidSomethingAppScoped(context: Context) : SomethingAppScoped

