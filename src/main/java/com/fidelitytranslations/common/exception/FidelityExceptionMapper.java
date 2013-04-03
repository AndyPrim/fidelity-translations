package com.fidelitytranslations.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Provider
public class FidelityExceptionMapper implements ExceptionMapper<FidetilyException> {
    protected static final Logger log = LogManager.getLogger(FidelityExceptionMapper.class);

    @Override
    public Response toResponse(FidetilyException exception) {
        ResponseBuilder builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
        builder.entity(exception.getFaultInfo().toResponse());
        builder.type(exception.getResponseFormat());
        log.warn(exception.getMessage(), exception);
        return builder.build();
    }
}
