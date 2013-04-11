package com.fidelitytranslations.services;

import java.util.List;

import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.common.interfaces.IDictionaryType;

public interface IMainService {

    public String getInfo() throws FidetilyException;

    public Integer getWorldCount(Integer fileId) throws FidetilyException;

    public <T extends IDictionaryType> List<T> getKeywords(Class<T> targetClass) throws FidetilyException;

}
