// RUN_PIPELINE_TILL: BACKEND
// SCOPE_DUMP: C:foo;x

interface A {
    fun foo(): Any
    val x: Any
}

interface B {
    fun foo(): Any
    val x: Any
}

interface C : A, B {
    override fun foo(): Any
    override val x: Any
}

/* GENERATED_FIR_TAGS: functionDeclaration, interfaceDeclaration, override, propertyDeclaration */
