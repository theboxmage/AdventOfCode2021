import java.util.stream.Collectors

class Day3(fileName: String) {
    private val fileService = FileService(fileName)

    fun solvePart1(): Int {
        val list: List<String> = fileService.getLinesAsString()
        var oxygen = ""
        var co2 = ""
        for (pos in 0 until list[0].length) {
            var count = 0
            for (bits in list) {
                count += if (bits[pos] == '1') 1 else -1
            }
            oxygen += if (count > 0) 1 else 0
            co2 += if (count < 0) 1 else 0
        }
        return Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)
    }

    fun solvePart2(): Int {
        val oxygenList: List<String> = fileService.getLinesAsString()
        val CO2List: List<String> = fileService.getLinesAsString()
        for (i in 0 until oxygenList[0].length) {
            var num: Int = oxygenList.stream().filter { it[i] == '1' }.collect(Collectors.toList()).size
            removeMatchingBit(oxygenList as ArrayList,i,if (oxygenList.size / 2 + oxygenList.size % 2 <= num) '0' else '1')
            num = CO2List.stream().filter { it[i] == '1' }.collect(Collectors.toList()).size
            removeMatchingBit(CO2List as ArrayList, i, if (CO2List.size / 2 + CO2List.size % 2 > num) '0' else '1')
        }
        return Integer.parseInt(oxygenList[0], 2) * Integer.parseInt(CO2List[0], 2)
    }

    private fun removeMatchingBit(list: ArrayList<String>, pos: Int, bit: Char) {
        for (i in list.size - 1 downTo 0) {
            if (list[i][pos] == bit && list.size > 1) {
                list.remove(list[i])
            }
        }
    }
}