package dev.santiago.request.credit.system.service.impl

import dev.santiago.request.credit.system.entity.Customer
import dev.santiago.request.credit.system.exception.BusinessException
import dev.santiago.request.credit.system.repository.CustomerRepository
import dev.santiago.request.credit.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }


    override fun delete(id: Long)  {
        val customer = this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }
        this.customerRepository.delete(customer)
    }


}