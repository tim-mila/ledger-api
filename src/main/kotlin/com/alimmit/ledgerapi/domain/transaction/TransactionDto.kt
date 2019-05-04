package com.alimmit.ledgerapi.domain.transaction

import java.math.BigDecimal
import java.util.*

class TransactionDto {
    lateinit var accountId: UUID
    lateinit var amount: BigDecimal
    lateinit var description: String
}