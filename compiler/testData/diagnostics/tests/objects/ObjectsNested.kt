// RUN_PIPELINE_TILL: FRONTEND
package nestedObejcts

object A {
    val b = B
    val d = A.B.A

    object B {
        val a = A
        val e = B.A

        object A {
            val a = A
            val b = B
            val x = nestedObejcts.A.B.A
            val y = this<!AMBIGUOUS_LABEL!>@A<!>
        }
    }

}
object B {
    val b = B
    val c = A.B
}

val a = A
val b = B
val c = A.B
val d = A.B.A
val e = B.<!UNRESOLVED_REFERENCE!>A<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>B<!>

/* GENERATED_FIR_TAGS: nestedClass, objectDeclaration, propertyDeclaration, thisExpression */
