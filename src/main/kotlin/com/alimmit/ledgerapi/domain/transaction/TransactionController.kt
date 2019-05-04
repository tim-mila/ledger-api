package com.alimmit.ledgerapi.domain.transaction

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.SortDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/transactions/{accountId}")
class TransactionController(val transactionService: TransactionService) {

    @GetMapping
    fun page(@PathVariable accountId: UUID, @PageableDefault(size = 25) @SortDefault(sort = [ "createdDate" ], direction = Sort.Direction.DESC) pageable: Pageable) : Page<Transaction> {
        return transactionService.page(accountId, pageable)
    }

    @PostMapping
    fun create(@PathVariable accountId: UUID, dto : TransactionDto) : Transaction {
        if (accountId == dto.accountId) {
            throw IllegalArgumentException()
        }
        return transactionService.create(dto)
    }
}