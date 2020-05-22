import java.util.*
//import kotlin.math.*
 
fun main() {
    val t = Scanner(System.`in`)
    var test = t.nextInt()
 
	while (test-- > 0) {
		var n = t.nextInt()
 
		if (n <= 3) {
			println("-1")
		} else {
			if ((n % 2) == 1) {
				var cur = 1
 
				while (cur <= n) {
				    print(cur)
				    print(" ")
					cur += 2
				}
 
				n -= (n / 2) + 1
				cur -= 2
 
				print(cur - 3)
				print(" ")
				print((cur - 1))
				print(" ")
				n -= 2

				if (n >= 1) {
					print(cur - 5)
					print(" ")
					n--
					cur = cur - 5
 
					while (n-- > 0) {
						print(cur - 2)
						print(" ")
						cur -= 2
					}
				}
 
				println()
 
			} else {
				var cur = 2

				while (cur <= n) {
					print(cur)
					print(" ")
					cur += 2
				}
 
				n -= (n / 2)
				cur -= 2
 
				print((cur - 3))
				print(" ")
				print((cur - 1))
				print(" ")
				n -= 2;
 
				if (n >= 1) {
					print(cur - 5)
					print(" ")
					n--
					cur = cur-5
 
					while (n-- > 0) {
						print(cur - 2)
						print(" ")
						cur -= 2
					}
				}
 
				println()
			}
		}
	}
}