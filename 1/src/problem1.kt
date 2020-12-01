import java.io.File
import kotlin.system.exitProcess

fun main() {
    val input : MutableList<Int> = readFileToList("src/input_1.txt").map { it.toInt() }.sorted().toMutableList()
    first(input);
    second(input);
}


fun first(input : MutableList <Int>) : Int{
    val result : Int;
    for (i in input){
        for (j in input.asReversed()){
            if (i+j==2020){
                result = i*j;
                print("Problem 1: i = $i  j = $j  result = $result \n")
                return result;
            }
        }
    }
    return -1;
}

fun second(input : MutableList<Int>) : Int{
    val result : Int;
    for (i in input.asReversed()){
        for ( j in input.asReversed()){
            if (i+j < 2020){
                for (k in input){
                    if (i+j+k == 2020){
                        result = i*j*k;
                        print("Problem 1: i = $i  j = $j  k = $k  result = $result \n")
                        return result;
                    }
                }
            }
        }
    }
    return -1;
}
fun readFileToList(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }