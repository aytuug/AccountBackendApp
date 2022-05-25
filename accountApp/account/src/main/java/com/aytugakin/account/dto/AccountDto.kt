package com.aytugakin.account.dto

import com.aytugakin.account.model.Customer
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(

        val id : String?,
        val balance : BigDecimal?,
        val creationDate: LocalDateTime,
        val customer: CustomerDto?,
        val transactions : Set<TransactionDto>,
)
