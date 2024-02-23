package dev.santiago.request.credit.system.service.impl

import dev.santiago.request.credit.system.entity.Custumer
import dev.santiago.request.credit.system.repository.CustomerRepository
import dev.santiago.request.credit.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Custumer): Custumer = this.customerRepository.save(customer)


    override fun findById(id: Long): Custumer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found")
        }


    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)

}