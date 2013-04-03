package com.fidelitytranslations.common.datamodels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({})
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "success", "totalCount", "data" })
public class ListResponse<T> {

    private Boolean success    = Boolean.TRUE;

    private Integer totalCount = 0;

    private List<T> data;

    public ListResponse() {
    }

    public ListResponse(List<T> data) {
        this(data, data.size(), Boolean.TRUE);
    }

    public ListResponse(T data) {
        this.data = new ArrayList<T>(1);
        this.data.add(data);
        this.totalCount = (data == null) ? 0 : 1;
        this.success = Boolean.TRUE;
    }

    public ListResponse(List<T> data, Integer totalCount) {
        this(data, totalCount, Boolean.TRUE);
    }

    public ListResponse(List<T> data, Integer totalCount, Boolean success) {
        this.data = data;
        this.totalCount = totalCount;
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    @XmlElement(name = "success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    @XmlElement(name = "totalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
