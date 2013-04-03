package com.fidelitytranslations.ws.impl;

import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fidelitytranslations.common.datamodels.VoidResponse;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.services.IMainService;
import com.fidelitytranslations.ws.IMainWS;

@WebService(endpointInterface = "com.fidelitytranslations.ws.IMainWS")
public class MainWSImpl implements IMainWS {

    protected static final Logger log = LogManager.getLogger(MainWSImpl.class);

    @Autowired
    private IMainService          mainService;

    public IMainService getMainService() {
        return mainService;
    }

    public void setMainService(IMainService mainService) {
        this.mainService = mainService;
    }

    @Override
    public VoidResponse getInfo() throws FidetilyException {
        String sMethod = "[getInfo()] ";
        log.debug(sMethod);
        log.debug("Result:" + mainService.getInfo());
        return new VoidResponse();
    }

}
