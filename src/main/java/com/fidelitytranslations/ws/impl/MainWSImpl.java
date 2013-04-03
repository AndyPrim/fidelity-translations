package com.fidelitytranslations.ws.impl;

import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fidelitytranslations.common.datamodels.VoidResponse;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.ws.IMainWS;

@WebService(endpointInterface = "com.fidelitytranslations.ws.IMainWS")
public class MainWSImpl implements IMainWS {

    protected static final Logger log = LogManager.getLogger(MainWSImpl.class);

    @Override
    public VoidResponse getInfo() throws FidetilyException {
        String sMethod = "[getInfo()] ";
        log.debug(sMethod);
        return new VoidResponse();
    }

}
