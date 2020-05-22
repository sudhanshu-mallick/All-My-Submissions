import java.util.*
//import kotlin.math.*
 
fun main() {
    val t = Scanner(System.`in`)
    var test = t.nextInt()
    
    while(test-- > 0){
        var a = t.nextInt()
        var b = t.nextInt()
        var c = t.nextInt()
        var d = t.nextInt()
 
    if ((a + d == b && a + d == c) || (b + c == a && b + c == d) || (b + d == a && b + d == c) || (a + c == b && a + c == d)) 
        println("Yes")
    else 
        println("No")

    }
}