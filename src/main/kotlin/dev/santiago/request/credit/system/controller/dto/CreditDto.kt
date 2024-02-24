package dev.santiago.request.credit.system.controller.dto

import dev.santiago.request.credit.system.entity.Credit
import dev.santiago.request.credit.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallment: Int,
    val customerId: Long
) {

  fun toEntity(): Credit = Credit(
      creditValue = this.creditValue,
      dayFirstInstallment = this.dayFirstInstallment,
      numberOfInstallment = this.numberOfInstallment,
      customer = Customer(id = this.customerId)
  )
}
