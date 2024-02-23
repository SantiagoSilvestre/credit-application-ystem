package dev.santiago.request.credit.system.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(nullable = false) var zipCod: String = "",
    @Column(nullable = false) var street: String = ""
)