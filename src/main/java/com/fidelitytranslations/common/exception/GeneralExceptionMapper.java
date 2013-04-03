package com.fidelitytranslations.common.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
    protected static final Logger log = LogManager.getLogger(GeneralExceptionMapper.class);

    @Override
    public Response toResponse(Exception exception) {
        ResponseBuilder builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
        FidelityFaultInfo fault = new FidelityFaultInfo();
        fault.setCode(ExceptionCodes.UNKNOWN_EXCEPTION);
        fault.setDescription(exception.getMessage());
        builder.entity(fault.toResponse());
        builder.type(MediaType.APPLICATION_JSON);

        log.warn(exception.getMessage(), exception);

        return builder.build();
    }
}
