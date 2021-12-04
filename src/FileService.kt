import java.io.File
import java.util.*

class FileService(var fileName: String) {
    fun getLinesAsString(): List<String> {
        val file = Scanner(File(fileName))
        val list = ArrayList<String>()
        while (file.hasNextLine()) {
            list.add(list.size, file.nextLine())
        }
        return list
    }

    fun getLinesAsInt(): List<Int> {
        val file = Scanner(File(fileName))
        val list = ArrayList<Int>()
        while (file.hasNextLine()) {
            list.add(list.size, Integer.parseInt(file.nextLine()))
        }
        return list
    }
}