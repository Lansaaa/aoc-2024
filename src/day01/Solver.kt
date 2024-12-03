package day01

import println
import readInput
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val list1 = PriorityQueue<Int>()
        val list2 = PriorityQueue<Int>()
        input.forEach {
            val array = it.split("   ")
            list1.offer(array[0].toInt())
            list2.offer(array[1].toInt())
        }
        var diff = 0
        while (list1.isNotEmpty()) {
            val item1 = list1.poll()
            val item2 = list2.poll()
            diff += abs(item2 - item1)
        }
        return diff
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val freq = HashMap<Int, Int>()
        input.forEach {
            val array = it.split("   ")
            list1.add(array[0].toInt())
            freq[array[1].toInt()] = (freq[array[1].toInt()] ?: 0) + 1
        }
        return list1.sumOf { (it * (freq[it] ?: 0)) }
    }

    val input = readInput("day01/input")
    "Part 1: ${part1(input)}".println()
    "Part 2: ${part2(input)}".println()
}
