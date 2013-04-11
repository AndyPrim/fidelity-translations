package com.fidelitytranslations.common.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public abstract class AbstractEntity {

    private static final int GEN_INITIAL_VALUE = 100;

    @Id
    @TableGenerator(name = "TAB_GEN", table = "tables_id_sequence", pkColumnName = "table_name",
            valueColumnName = "next_value", initialValue = GEN_INITIAL_VALUE, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TAB_GEN")
    private Integer          id;

    public void setId(final Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    public final static <T> boolean compareField(T p1, T p2) {
        if (p1 == null && p2 != null)
            return false;
        if (p2 == null && p1 != null)
            return false;
        if (p1 != null && p2 != null && !p1.equals(p2))
            return false;
        return true;
    }
}
