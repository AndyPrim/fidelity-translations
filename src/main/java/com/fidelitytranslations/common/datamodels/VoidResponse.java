package com.fidelitytranslations.common.datamodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class VoidResponse {

    private Boolean success = Boolean.TRUE;

    private Boolean data    = Boolean.TRUE;

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }

    public VoidResponse() {
    }

    public VoidResponse(Boolean success) {
        this.success = success;
    }

    public VoidResponse(Boolean success, Boolean data) {
        this(success);
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    @XmlElement(name = "success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
