package dev.santiago.request.credit.system.service

import dev.santiago.request.credit.system.entity.Credit
import dev.santiago.request.credit.system.entity.Custumer
import java.util.*

interface ICustomerService {

    fun save(customer: Custumer): Custumer

    fun findById(id: Long): Custumer

    fun delete(id: Long)

}