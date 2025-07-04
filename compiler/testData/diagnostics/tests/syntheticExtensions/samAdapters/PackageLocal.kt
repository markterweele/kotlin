// RUN_PIPELINE_TILL: FRONTEND
// FILE: KotlinFile1.kt
package k

import JavaClass

fun foo(javaClass: JavaClass) {
    javaClass.<!INVISIBLE_MEMBER!>doSomething<!> { }
}

// FILE: KotlinFile2.kt
fun foo(javaClass: JavaClass) {
    javaClass.doSomething { }
}

// FILE: JavaClass.java
public class JavaClass {
    void doSomething(Runnable runnable) { runnable.run(); }
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaType, lambdaLiteral, samConversion */
