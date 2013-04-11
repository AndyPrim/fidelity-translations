package com.fidelitytranslations.common.storages;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelitytranslations.common.exception.ExceptionCodes;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.common.interfaces.IStorage;

public class FileStorage implements IStorage {

    private static final Logger log = LogManager.getLogger(FileStorage.class);

    @Autowired
    private SessionFactory      sessionFactory;

    private static String       rootPath;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static String getRootPath() {
        return rootPath + File.separator;
    }

    @Autowired(required = true)
    public void setRootPath(String rootPath) {
        FileStorage.rootPath = rootPath;
    }

    @Override
    public InputStream getContent(Integer contentId) throws FidetilyException {
        log.trace("getContent: id=" + contentId);
        File file = getFile(contentId);
        InputStream result = null;
        try {
            result = FileUtils.openInputStream(file);
        } catch (IOException e) {
            throw new FidetilyException(ExceptionCodes.FILE_IO_EXCEPTION, e);
        }
        return result;
    }

    @Override
    public File getFile(Integer contentId) throws FidetilyException {
        log.trace("getFile: id=" + contentId);
        String fileName = getRootPath() + getPath(contentId);
        File file = new File(fileName);
        if (!file.exists()) {
            new FidetilyException(ExceptionCodes.FILE_NOT_FOUND_EXCEPTION);
        }
        return file;
    }

    @Override
    public void createContent(Integer contentId, InputStream data) throws FidetilyException {
        log.trace("createContent: id=" + contentId);
        String path = getPath(contentId);
        String fileName = getRootPath() + path;
        File file = new File(fileName);
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(FileUtils.openOutputStream(file));
            IOUtils.copyLarge(data, out);
        } catch (IOException e) {
            throw new FidetilyException(ExceptionCodes.FILE_CREATE_EXCEPTION, e);
        } finally {
            IOUtils.closeQuietly(data);
            IOUtils.closeQuietly(out);
        }
    }

    public static String getPath(Integer contentId) {
        return contentId.toString();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteContent(final Integer contentId) throws FidetilyException {
        log.trace("deleteContent: id=" + contentId);
        String docPath = getRootPath() + getPath(contentId);
        File file = new File(docPath);
        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            throw new FidetilyException(ExceptionCodes.FILE_IO_EXCEPTION, e);
        }
    }
}
