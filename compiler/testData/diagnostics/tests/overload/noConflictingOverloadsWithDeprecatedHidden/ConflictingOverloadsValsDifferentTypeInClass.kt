// RUN_PIPELINE_TILL: BACKEND
class Aaa() {
    val <!REDECLARATION!>a<!> = 1
    @Deprecated("a", level = DeprecationLevel.HIDDEN)
    val <!REDECLARATION!>a<!> = ""
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, propertyDeclaration, stringLiteral */
