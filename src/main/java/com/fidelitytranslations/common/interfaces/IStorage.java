package com.fidelitytranslations.common.interfaces;

import java.io.File;
import java.io.InputStream;

import com.fidelitytranslations.common.exception.FidetilyException;

public interface IStorage {

    /** Get document content
     * @param contentId content identifier
     * @return input stream of the content
     * @throws FidetilyException
     */
    public InputStream getContent(Integer contentId) throws FidetilyException;
    
    public File getFile(Integer contentId) throws FidetilyException;

    /** Create a document content
     * @param contentId content identifier
     * @param data document content data
     * @throws FidetilyException
     */
    public void createContent(Integer contentId, InputStream data) throws FidetilyException;

    /** Delete the document content
     * @param contentId content identifier
     * @throws FidetilyException
     */
    public void deleteContent(Integer contentId) throws FidetilyException;
}
