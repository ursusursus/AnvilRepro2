package sk.foo.scopes

import javax.inject.Scope

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 25. 7. 2021.
 */
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class AppScope

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class SubScope

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class LibraryScope