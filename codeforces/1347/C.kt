import java.util.*
//import kotlin.math.*
 
fun main() {
    val t = Scanner(System.`in`)
    var test = t.nextInt()
   // println(test)
    
    while(test-- > 0){
        var sp = t.nextInt()
        var s = Integer.toString(sp)
		var n = s.length;
		var i = 0;
		var l = ArrayList<String>()
 
		while (i < n) {
			var rem: Int = (s[i]) - '0'
 
			if (rem > 0) {
				var sb = StringBuilder("")
 
				sb.append(rem);
				
				var j = i + 1;
				
				while(j < n) {  
				    sb.append('0');
				    j++;
				}
 
				l.add(sb.toString());
				}
 
				i++;
			}
			
			println(l.size);
			
			var j = 0;
			
			while(j < l.size){
			   	print(l[j] + " ")
			   	j++
			}
 
			println();

    }
}