// RUN_PIPELINE_TILL: FRONTEND

fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null

    val a = object {
        fun baz() = bar(if (x == null) 0 else x)
        fun quux(): Int = <!RETURN_TYPE_MISMATCH!>if (x == null) x else x<!>
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, anonymousObjectExpression, equalityExpression, functionDeclaration,
ifExpression, integerLiteral, localProperty, nullableType, propertyDeclaration, smartcast */
