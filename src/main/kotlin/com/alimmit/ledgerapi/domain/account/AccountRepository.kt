package com.alimmit.ledgerapi.domain.account

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "accounts", path = "account")
interface AccountRepository : CrudRepository<Account, UUID>