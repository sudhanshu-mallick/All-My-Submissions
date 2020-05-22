import java.util.*
//import kotlin.math.*
 
fun main() {
    val t = Scanner(System.`in`)
    var test = t.nextInt()
 
	while (test-- > 0) {
		var n = t.nextInt()
		var a = ArrayList<Int>()
        
        var okk = 0
        
        while(okk < n) {
            var el = t.nextInt()
            a.add(el)
            okk++
        }
 
		var i = 1
		var j = n - 1
		var count = 1
		var ac = a[0]
		var bc = 0
		var al = a[0]
		var bo = 0
		var f = true
 
		while (i <= j) {
			if (f) {
				while (j >= i) {
					if (bc <= ac) {
						bo += a[j]
						bc += a[j]
						j--
					} else
						break
				}
 
				f = false;
				ac = 0;
			} else {
				while (i <= j) {
					if (bc >= ac) {
						al += a[i]
						ac += a[i]
						i++
					} else
						break
				}
 
				f = true
				bc = 0
			}
 
			count++;
		}
 
		print(count)
		print(" ")
		print(al)
		print(" ")
		println(bo)
	}
}