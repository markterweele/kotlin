// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

private typealias Bar = Foo<Gau>
internal class Gau : Bar

internal class Gau2 : Bar2
private typealias Bar2 = Foo<Gau2>

//internal class Gau : Foo<Gau>

interface Foo<T>

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, typeAliasDeclaration, typeParameter */
