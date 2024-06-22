package com.shortthirdman.medihub.configuration;

import com.shortthirdman.medihub.common.annotation.ApiCallable;
import com.shortthirdman.medihub.common.exception.NotFoundException;
import com.shortthirdman.medihub.common.exception.ServiceUnavailableException;
import com.shortthirdman.medihub.common.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalRestExceptionHandler {

    public static <T> T handleApiCall(ApiCallable<T> apiCallable) {
        try {
            return apiCallable.call();
        } catch (UnauthorizedException ue) {
            log.error("Unauthorized access", ue);
            throw ue;
        } catch (NotFoundException nfe) {
            log.error("Resource not found", nfe);
            throw nfe;
        } catch (ServiceUnavailableException sue) {
            log.error("Service unavailable", sue);
            throw sue;
        } catch (Exception e) {
            log.error("An unexpected error occurred", e);
            throw new RuntimeException("Unexpected error occurred", e);
        }
    }
}
