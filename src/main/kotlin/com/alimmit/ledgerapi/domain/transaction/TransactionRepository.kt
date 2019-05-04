package com.alimmit.ledgerapi.domain.transaction

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TransactionRepository : JpaRepository<Transaction, UUID> {

    fun findByAccountId(accountId : UUID, pageable: Pageable) : Page<Transaction>
}