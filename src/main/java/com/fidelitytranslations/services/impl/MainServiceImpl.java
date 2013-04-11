package com.fidelitytranslations.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.fidelitytranslations.common.exception.ExceptionCodes;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.common.interfaces.IDictionaryType;
import com.fidelitytranslations.common.interfaces.IStorage;
import com.fidelitytranslations.services.IMainService;

public class MainServiceImpl implements IMainService {

    protected static final Logger log = LogManager.getLogger(MainServiceImpl.class);

    @Autowired
    private SessionFactory        sessionFactory;

    @Autowired
    private IStorage              storageService;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public IStorage getStorageService() {
        return storageService;
    }

    public void setStorageService(IStorage storageService) {
        this.storageService = storageService;
    }

    @Override
    public String getInfo() throws FidetilyException {
        String sMethod = "[getInfo()] ";
        log.trace(sMethod);
        return "Hello!!!";

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public <T extends IDictionaryType> List<T> getKeywords(Class<T> targetClass) throws FidetilyException {
        String sMethod = "[getKeywords()] ";
        log.trace(sMethod);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(targetClass).addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Override
    public Integer getWorldCount(Integer fileId) throws FidetilyException {
        String sMethod = "[getWorldCount] ";
        log.trace(sMethod);
        OutputStream os = new ByteArrayOutputStream();
        ContentHandler handler = new BodyContentHandler(os);
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        //Parser parser = TikaConfig.getDefaultConfig().getParser();
        File file = storageService.getFile(fileId);
        TikaInputStream is = null;
        int worldCount = 0;
        try {
            is = TikaInputStream.get(file);
            parser.parse(is, handler, metadata, new ParseContext());
            String[] result = os.toString().split("[\\s\\d{}().,;:/\\[\\]+*\\^\\-]+");
            Map<String, Integer> words = new HashMap<String, Integer>();
            for (String string : result) {
                if (!string.isEmpty() && !string.equals("-")) {
                    worldCount++;
                    if (words.containsKey(string)) {
                        words.put(string, words.get(string) + 1);
                    } else {
                        words.put(string, 1);
                    }
                }
            }
            /*Iterator<Map.Entry<String, Integer>> entries = words.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Integer> entry = entries.next();
                System.out.println("Word = " + entry.getKey() + ", Count = " + entry.getValue());
            }*/
        } catch (IOException e) {
            throw new FidetilyException(ExceptionCodes.FILE_IO_EXCEPTION, e);
        } catch (SAXException e) {
            throw new FidetilyException(ExceptionCodes.TIKA_EXCEPTION, e);
        } catch (TikaException e) {
            throw new FidetilyException(ExceptionCodes.TIKA_EXCEPTION, e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        /*for (String name : metadata.names()) {
            String value = metadata.get(name);

            if (value != null) {
                System.out.println("Metadata Name:  " + name);
                System.out.println("Metadata Value: " + value);
            }
        }*/
        log.trace("word count: " + worldCount);
        return worldCount;
    }

}
