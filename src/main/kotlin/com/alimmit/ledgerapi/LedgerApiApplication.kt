package com.alimmit.ledgerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LedgerApiApplication

fun main(args: Array<String>) {
	runApplication<LedgerApiApplication>(*args)
}
