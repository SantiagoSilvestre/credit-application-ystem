package dev.santiago.request.credit.system.controller

import dev.santiago.request.credit.system.controller.dto.CreditDto
import dev.santiago.request.credit.system.controller.dto.CreditView
import dev.santiago.request.credit.system.controller.dto.CreditViewList
import dev.santiago.request.credit.system.entity.Credit
import dev.santiago.request.credit.system.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun save(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
        val savedCredit = this.creditService.save(credit = creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${savedCredit.creditCode} - Customer ${savedCredit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> =
        ResponseEntity.status(HttpStatus.OK).body(
            this.creditService.findAllByCustomer(customerId)
                .stream()
                .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
        )

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }

}