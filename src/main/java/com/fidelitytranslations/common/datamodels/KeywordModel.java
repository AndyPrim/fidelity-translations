package com.fidelitytranslations.common.datamodels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.fidelitytranslations.common.exception.ExceptionCodes;
import com.fidelitytranslations.common.exception.FidetilyException;
import com.fidelitytranslations.common.interfaces.IDictionaryType;
import com.fidelitytranslations.common.providers.FidelityObjectMapper;

@XmlRootElement(name = "keyword")
public class KeywordModel implements IDictionaryType {

    private Integer id;
    private String  name;

    public KeywordModel() {
    }

    public KeywordModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KeywordModel [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
                + "]";
    }

    public static KeywordModel valueOf(String s) throws Exception {
        return (new FidelityObjectMapper()).readValue(s, KeywordModel.class);
    }

    public static <T extends IDictionaryType> KeywordModel EntityToModel(T item) {
        KeywordModel model = new KeywordModel();
        model.setId(item.getId());
        model.setName(item.getName());
        return model;
    }

    public static <T extends IDictionaryType> T ModelToEntity(KeywordModel item, Class<T> entityClass)
            throws FidetilyException {
        T entity = null;
        try {
            entity = entityClass.newInstance();
            entity.setId(item.id);
            entity.setName(item.name);
        } catch (InstantiationException e) {
            throw new FidetilyException(ExceptionCodes.WRONG_INPUT_PARAMETERS_EXCEPTION, e);
        } catch (IllegalAccessException e) {
            throw new FidetilyException(ExceptionCodes.WRONG_INPUT_PARAMETERS_EXCEPTION, e);
        }
        return entity;
    }

    public static <T extends IDictionaryType> List<KeywordModel> EntityToModel(Collection<T> items) {

        List<KeywordModel> rezList = new ArrayList<KeywordModel>();
        for (IDictionaryType item : items) {
            rezList.add(KeywordModel.EntityToModel(item));
        }
        return rezList;
    }

    public static <T extends IDictionaryType> Set<T> ModelToEntity(Collection<KeywordModel> items, Class<T> entityClass)
            throws FidetilyException {
        Set<T> result = new HashSet<T>(items.size());
        for (KeywordModel item : items) {
            result.add(KeywordModel.ModelToEntity(item, entityClass));
        }
        return result;
    }
}
