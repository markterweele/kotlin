// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-31679

import kotlin.reflect.KProperty

class MyDelegate<T>(p: () -> T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = TODO()
}

private val privateObj by MyDelegate {
    object {
        val x = 42
    }
}

fun test() {
    privateObj.x
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, nullableType, operator, primaryConstructor, propertyDeclaration, propertyDelegate, starProjection,
typeParameter */
