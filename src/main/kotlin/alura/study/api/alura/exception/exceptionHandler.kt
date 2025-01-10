package alura.study.api.alura.exception

import alura.study.api.alura.dto.ErrorViewDTO
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class exceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorViewDTO {
        return ErrorViewDTO(
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            status = HttpStatus.NOT_FOUND.value(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerServerError(
        exception: Exception,
        request: HttpServletRequest
    ): ErrorViewDTO {
        return ErrorViewDTO(
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorViewDTO {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
                e -> errorMessage.put(e.field, e.defaultMessage)
        }
        return ErrorViewDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }
}