// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -NOTHING_TO_INLINE
// SKIP_TXT
// WITH_COROUTINES
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*
import helpers.*

interface SuspendRunnable {
    suspend fun run()
}

// Function is suspend
// parameter is crossinline
// parameter is suspend
// Block is allowed to be called inside the body of owner inline function
// Block is allowed to be called from nested classes/lambdas (as common crossinlines)
// It is NOT possible to call startCoroutine on the parameter
// suspend calls possible inside lambda matching to the parameter
suspend inline fun test(crossinline c: suspend () -> Unit) {
    c()
    val o = object : SuspendRunnable {
        override suspend fun run() {
            c()
        }
    }
    val l: suspend () -> Unit = { c() }
    <!USAGE_IS_NOT_INLINABLE!>c<!>.startCoroutine(EmptyContinuation)
}

fun builder(c: suspend () -> Unit) {}

suspend fun calculate() = "OK"

fun box() {
    builder {
        test {
            calculate()
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, assignment, classDeclaration, companionObject, crossinline,
functionDeclaration, functionalType, inline, interfaceDeclaration, lambdaLiteral, localProperty, nullableType,
objectDeclaration, override, primaryConstructor, propertyDeclaration, safeCall, stringLiteral, suspend, thisExpression,
typeParameter */
