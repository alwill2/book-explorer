package org.book.explorer.web.exception;

import java.util.UUID;

public record ErrorResponse(
    UUID referenceCode,
    String errorCode,
    String description
) {

}
