package com.fidelitytranslations.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fidelitytranslations.common.entities.AbstractEntity;
import com.fidelitytranslations.common.interfaces.IDictionaryType;

@Entity
@Table(name = "languages")
public class DictLanguages extends AbstractEntity implements IDictionaryType {

    @Column(name = "name")
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        DictLanguages that = (DictLanguages) obj;
        if (!this.getName().equals(that.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int multiplier = 31;
        int hash = 1;
        hash = hash * multiplier + this.getName().hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
