package com.fidelitytranslations.services.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.services.IMainService;

public class MainServiceImpl implements IMainService {

    protected static final Logger log = LogManager.getLogger(MainServiceImpl.class);

    @Autowired
    private SessionFactory        sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String getInfo() throws FidetilyException {
        String sMethod = "[getInfo()] ";
        log.debug(sMethod);
        log.debug(sessionFactory.isClosed());
        return "Hello!!!";

    }

}
