package com.alimmit.ledgerapi.domain.transaction

import com.alimmit.ledgerapi.domain.Auditable
import com.alimmit.ledgerapi.domain.account.Account
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@EntityListeners(value = [ AuditingEntityListener::class ])
class Transaction : Auditable() {

    enum class Type {
        Debit, Credit
    }

    enum class Status {
        Planned, Pending, Posted
    }

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true, updatable = false)
    var id: UUID? = null

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, updatable = false)
    lateinit var account : Account

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = true)
    lateinit var type : Type

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = true)
    lateinit var status : Status

    @Column(nullable = false, updatable = true)
    lateinit var description : String

    @Column(nullable = false, updatable = true)
    lateinit var amount : BigDecimal
}