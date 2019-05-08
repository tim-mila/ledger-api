package com.alimmit.ledgerapi.domain.transaction

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.SortDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/transaction")
class TransactionController(val transactionService: TransactionService) {

    @GetMapping
    fun page(@RequestParam("accountId") accountId: UUID, @PageableDefault(size = 25) @SortDefault(sort = [ "createdDate" ], direction = Sort.Direction.DESC) pageable: Pageable) : Page<Transaction> {
        return transactionService.page(accountId, pageable)
    }

    @PostMapping
    fun create(dto : TransactionDto) : Transaction {
        return transactionService.create(dto)
    }
}