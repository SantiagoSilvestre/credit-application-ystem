package dev.santiago.request.credit.system.service

import dev.santiago.request.credit.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)

}