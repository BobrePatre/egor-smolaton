package ru.umom.hackaton

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HackatonApplication

fun main(args: Array<String>) {
    runApplication<HackatonApplication>(*args)
}
