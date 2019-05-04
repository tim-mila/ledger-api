package com.alimmit.ledgerapi.domain.transaction

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface TransactionService {

    fun page(accountId: UUID, pageable : Pageable) : Page<Transaction>

    fun create(transactionDto: TransactionDto) : Transaction
}