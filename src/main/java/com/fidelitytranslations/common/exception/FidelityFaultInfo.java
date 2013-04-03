package com.fidelitytranslations.common.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.ObjectMapper;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SymfoniException", propOrder = { "success", "code", "description" })
@XmlRootElement(name = "FidelityFaultInfo")
public class FidelityFaultInfo {

    private Boolean        success = Boolean.FALSE;
    private ExceptionCodes code    = ExceptionCodes.NOT_EXCEPTION; ;
    private String         description;

    public ExceptionCodes getCode() {
        return code;
    }

    public void setCode(ExceptionCodes code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String toResponse() {
        String response = null;
        try {
            response = (new ObjectMapper()).writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
