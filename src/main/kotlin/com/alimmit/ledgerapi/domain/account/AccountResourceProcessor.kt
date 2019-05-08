package com.alimmit.ledgerapi.domain.account

import com.alimmit.ledgerapi.domain.transaction.TransactionController
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.stereotype.Component
import kotlin.reflect.jvm.javaMethod


@Component
class AccountResourceProcessor(val configuration: RepositoryRestMvcConfiguration) : ResourceProcessor<Resource<Account>> {

    override fun process(resource: Resource<Account>?): Resource<Account> {
        val link = ControllerLinkBuilder.linkTo(TransactionController::class.java, TransactionController::page.javaMethod).slash("?accountId={accountId}")

        resource!!.add(link.withRel("transactions").expand(resource.content.id))
        return resource
    }
}