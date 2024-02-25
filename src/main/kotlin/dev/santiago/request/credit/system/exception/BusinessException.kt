package dev.santiago.request.credit.system.exception

import java.lang.RuntimeException

data class BusinessException(override val message: String?) : RuntimeException(message)