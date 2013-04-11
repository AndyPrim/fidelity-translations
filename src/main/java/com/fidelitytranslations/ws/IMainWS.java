package com.fidelitytranslations.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

import com.fidelitytranslations.common.datamodels.KeywordModel;
import com.fidelitytranslations.common.datamodels.ListResponse;
import com.fidelitytranslations.common.exception.FidetilyException;

@Path("/main")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@WebService
@MTOM(enabled = true)
@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public interface IMainWS {

    @GET
    @Path("/getInfo")
    @WebMethod
    public @WebResult(name = "result")
    ListResponse<String> getInfo() throws FidetilyException;

    @GET
    @Path("/getLanguages")
    @WebMethod
    public @WebResult(name = "languages")
    ListResponse<KeywordModel> getLanguages() throws FidetilyException;

    @GET
    @Path("/getSectors")
    @WebMethod
    public @WebResult(name = "sectors")
    ListResponse<KeywordModel> getSectors() throws FidetilyException;

    @GET
    @Path("/getWordCount")
    @WebMethod
    public @WebResult(name = "wordCount")
    ListResponse<Integer> getWordCount() throws FidetilyException;

}
