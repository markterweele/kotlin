// RUN_PIPELINE_TILL: BACKEND
fun fn(c: Char?): Any? =
        if (c == null) TODO()
        else when (c) {
            'a' -> when (c) {
                'B' -> 1
                'C' -> "sdf"
                else -> TODO()
            }
            else -> TODO()
        }

/* GENERATED_FIR_TAGS: equalityExpression, functionDeclaration, ifExpression, integerLiteral, nullableType, smartcast,
stringLiteral, whenExpression, whenWithSubject */
