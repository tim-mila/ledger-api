package com.alimmit.ledgerapi.domain.account

import com.alimmit.ledgerapi.domain.transaction.Transaction
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.stereotype.Component


@Component
class AccountResourceProcessor(val configuration: RepositoryRestMvcConfiguration) : ResourceProcessor<Resource<Account>> {

    override fun process(resource: Resource<Account>?): Resource<Account> {
        val link = configuration.entityLinks().linkForSingleResource(Transaction::class.java, resource!!.content.id)
        resource.add(link.withRel("transaction"))
        return resource
    }
}