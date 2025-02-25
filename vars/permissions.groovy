@groovy.transform.Field
String locoq = "loco"

public def hello() {
    println(locoq)
}

public def bye() {
    println("Bye ${locoq}")
}