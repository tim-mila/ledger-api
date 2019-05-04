package com.alimmit.ledgerapi.domain.account

import com.alimmit.ledgerapi.domain.Auditable
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

/**
 * Bank account definition
 */
@Entity(name = "account")
@EntityListeners(value = [ AuditingEntityListener::class ])
class Account : Auditable() {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true, updatable = false)
    var id: UUID? = null

    @Column(nullable = false, name = "account_name")
    lateinit var name: String
}