package com.fidelitytranslations.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fidelitytranslations.common.datamodels.KeywordModel;
import com.fidelitytranslations.common.datamodels.ListResponse;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.entities.DictLanguages;
import com.fidelitytranslations.entities.DictSectors;
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
    public ListResponse<String> getInfo() throws FidetilyException {
        String sMethod = "[getInfo()] ";
        log.debug(sMethod);
        String message = mainService.getInfo();
        log.debug("Result:" + message);
        return new ListResponse<String>(message);
    }

    @Override
    public ListResponse<KeywordModel> getLanguages() throws FidetilyException {
        String sMethod = "[getLanguages()] ";
        log.debug(sMethod);
        List<DictLanguages> entities = mainService.getKeywords(DictLanguages.class);
        List<KeywordModel> result = KeywordModel.EntityToModel(entities);
        log.debug("Result size:" + result.size());
        return new ListResponse<KeywordModel>(result);
    }

    @Override
    public ListResponse<KeywordModel> getSectors() throws FidetilyException {
        String sMethod = "[getSectors()] ";
        log.debug(sMethod);
        List<DictSectors> entities = mainService.getKeywords(DictSectors.class);
        List<KeywordModel> result = KeywordModel.EntityToModel(entities);
        log.debug("Result size:" + result.size());
        return new ListResponse<KeywordModel>(result);
    }

    @Override
    public ListResponse<Integer> getWordCount() throws FidetilyException {
        String sMethod = "[getWordCount()] ";
        log.debug(sMethod);
        Integer wordCount = mainService.getWorldCount(1);
        log.debug("Result:" + wordCount);
        return new ListResponse<Integer>(wordCount);
    }
}
