package dev.santiago.request.credit.system.controller.dto

import dev.santiago.request.credit.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCod = this.zipCode
        customer.address.street = this.street
        return  customer
    }
}