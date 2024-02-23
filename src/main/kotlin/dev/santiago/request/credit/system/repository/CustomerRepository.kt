package dev.santiago.request.credit.system.repository

import dev.santiago.request.credit.system.entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Custumer, Long>