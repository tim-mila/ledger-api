package com.alimmit.ledgerapi.domain.transaction

import com.alimmit.ledgerapi.domain.account.AccountRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional
import kotlin.NoSuchElementException

@Service
@Transactional
class TransactionServiceImpl(val transactionRepository: TransactionRepository, val accountRepository: AccountRepository) : TransactionService {

    override fun create(transactionDto: TransactionDto): Transaction {

        val account = accountRepository.findById(transactionDto.accountId).orElseThrow { NoSuchElementException("Account not found") }

        val transaction = Transaction()
        transaction.account = account
        transaction.amount = transactionDto.amount
        transaction.description = transactionDto.description
        transaction.type = transactionDto.type
        transaction.status = Transaction.Status.Pending

        return transactionRepository.save(transaction)
    }

    override fun page(accountId : UUID, pageable: Pageable): Page<Transaction> {
        return transactionRepository.findByAccountId(accountId, pageable)
    }
}