package com.mastertech.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuario não encontrado")
public class UserNotFoundException extends RuntimeException {
}
