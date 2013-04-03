package com.fidelitytranslations.common.exception;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "FidetilyFaultInfo", name = "FidetilyFaultInfo")
public class FidetilyException extends Exception {
    private static final long serialVersionUID = 7394064857474301283L;

    private FidelityFaultInfo faultInfo        = new FidelityFaultInfo();

    private String            responseFormat   = MediaType.APPLICATION_JSON;

    public FidetilyException() {
        super();
    }

    public FidetilyException(ExceptionCodes code) {
        super(code.toString());
        faultInfo.setCode(code);
    }

    public FidetilyException(ExceptionCodes code, Throwable th) {
        super(code.toString(), th);
        faultInfo.setCode(code);
    }

    public FidetilyException(Throwable th) {
        super(th);
    }

    public FidetilyException(String mess, Throwable th) {
        super(mess, th);
    }

    public FidetilyException(String message, FidelityFaultInfo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public FidetilyException(String message, FidelityFaultInfo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public FidelityFaultInfo getFaultInfo() {
        return faultInfo;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }

}
