package dev.santiago.request.credit.system.controller.dto

import dev.santiago.request.credit.system.entity.Address
import dev.santiago.request.credit.system.entity.Customer
import java.math.BigDecimal

data class CustomerDto(
    val firstName: String,
    val lasName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val stret: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lasName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            this.zipCode,
            this.stret
        )

    )
}