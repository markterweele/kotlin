// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT
fun baz(options: String = ""): String = ""
fun bar(normalizeNames: Boolean = false): String = ""

fun <E> select(x: E, y: E) = x
fun <E> id(e: E): E = e

fun runForString(x: () -> String) {}

val cs: CharSequence = ""

fun foo(dumpStrategy: String) {
    val dump0: () -> String = <!TYPE_MISMATCH!>::<!TYPE_MISMATCH!>baz<!><!> // TYPE_MISMATCH
    val dump1: () -> String = <!TYPE_MISMATCH, TYPE_MISMATCH!>id(::baz)<!> // TYPE_MISMATCH
    // OK, TYPE_MISMATCH IN K2
    val dump2: () -> String = if (dumpStrategy == "KotlinLike") ::baz else ::bar
    val dump3: () -> String = <!TYPE_MISMATCH, TYPE_MISMATCH, TYPE_MISMATCH!>select(::baz, ::bar)<!> // TYPE_MISMATCH

    var dump4: () -> String = if (dumpStrategy == "KotlinLike") ::baz else ::bar
    dump4.invoke()
    dump4 = if (dumpStrategy == "KotlinLike") ::baz else ::bar

    var dump5: () -> CharSequence = { cs }
    expectString(<!TYPE_MISMATCH!>dump5.invoke()<!>)
    dump5 = if (dumpStrategy == "KotlinLike") ::baz else ::bar
    // `dump5` should have smart cast to () -> String
    expectString(<!DEBUG_INFO_SMARTCAST!>dump5<!>.invoke())
}

fun expectString(x: String) {}

/* GENERATED_FIR_TAGS: assignment, callableReference, equalityExpression, functionDeclaration, functionalType,
ifExpression, intersectionType, lambdaLiteral, localProperty, nullableType, propertyDeclaration, smartcast,
stringLiteral, typeParameter */
