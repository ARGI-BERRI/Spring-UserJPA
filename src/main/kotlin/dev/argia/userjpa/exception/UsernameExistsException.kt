package dev.argia.userjpa.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class UsernameExistsException: RuntimeException("Requested username is already exists.")

