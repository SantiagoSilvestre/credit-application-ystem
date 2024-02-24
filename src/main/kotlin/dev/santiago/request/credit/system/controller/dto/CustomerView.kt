package dev.santiago.request.credit.system.controller.dto

import dev.santiago.request.credit.system.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    constructor(custumer: Customer): this (
        firstName = custumer.firstName,
        lastName = custumer.lastName,
        cpf = custumer.cpf,
        income = custumer.income,
        email = custumer.email,
        zipCode = custumer.address.zipCod,
        street = custumer.address.street
    )
}
