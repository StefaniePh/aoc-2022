import kotlin.jvm.JvmStatic
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import java.io.IOException
import java.util.Objects
import java.util.function.Consumer

object solution {
    var maxCalorieSum = 0
    var currentCalorieSum = 0
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            Files.lines(Paths.get("day-1/input/input.txt"))
                    .map { e: String -> if (e == "") null else e.toInt() }
                    .collect(Collectors.toList())
                    .forEach(Consumer { obj: Int? -> processNextLine(obj) })
            println(maxCalorieSum)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun processNextLine(e: Int?) {
        if (Objects.isNull(e)) {
            maxCalorieSum = Integer.max(maxCalorieSum, currentCalorieSum)
            currentCalorieSum = 0
        } else {
            currentCalorieSum += e!!
        }
    }
}