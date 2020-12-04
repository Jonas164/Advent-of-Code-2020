import java.io.File
import kotlin.math.max

const val min = 0;
const val max = 127;
fun readFileToList(fileName: String): List<String> = File(fileName).useLines { it.toList() }


fun main() {
    val input: List<String> = readFileToList("5/src/input_1.txt")
    print(solve(input));
}


fun solve(input: List<String>): Int {
    var highest: Int = -1;
    for (s in input) {
        highest = max(solve_row(s, min, max), highest);
    }
    return highest;
}


fun solve_row(pass: String, min: Int, max: Int): Int {
    return when (pass[0]) {
        'F' -> solve_row(pass.substring(1), min, (min + max) / 2)
        'B' -> solve_row(pass.substring(1), (min + max) / 2 + 1, max)
        else -> solve_col(pass.substring(1), min, 0, 8)
    }
}

fun solve_col(pass: String, row: Int, min: Int, max: Int): Int {
    if (pass.isEmpty()) {
        return row * 8 + min;
    }
    when (pass[0]) {
        'L' -> return solve_col(pass.substring(1), row, min, (min + max) / 2)
        'R' -> return solve_col(pass.substring(1), row, (min + max) / 2 + 1, max)
    }
    return -1;
}