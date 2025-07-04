// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//KT-3174 Call resolver doesn't understand type is not-nullable after ?. safe call
package a

fun <T: Any> T.test(): T = this
fun foo(a: Any?) = a?.test() // Error

fun <T> T.fff(l: MutableList<T>) = l.add(this)

fun test(s: String?, l: MutableList<String>) {
    s?.fff(l)

}

/* GENERATED_FIR_TAGS: funWithExtensionReceiver, functionDeclaration, nullableType, safeCall, thisExpression,
typeConstraint, typeParameter */
