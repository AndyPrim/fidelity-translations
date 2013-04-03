package com.fidelitytranslations.common.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WebExceptionMapper implements ExceptionMapper<WebApplicationException> {
    protected static final Logger log = LogManager.getLogger(WebExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException exception) {
        ResponseBuilder builder = Response.status(exception.getResponse().getStatus());
        FidelityFaultInfo fault = new FidelityFaultInfo();
        fault.setCode(ExceptionCodes.UNKNOWN_EXCEPTION);
        String errorMessage = null;
        if (exception.getMessage() != null) {
            errorMessage = exception.getMessage();
        } else {
            if (exception.getResponse().getEntity() != null) {
                errorMessage = exception.getResponse().getEntity().toString();
            }
        }
        fault.setDescription(errorMessage);
        builder.entity(fault.toResponse());
        builder.type(MediaType.APPLICATION_JSON);

        log.warn(exception.getMessage(), exception);
        return builder.build();
    }
}
