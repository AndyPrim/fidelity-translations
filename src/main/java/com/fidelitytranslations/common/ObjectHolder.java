package com.fidelitytranslations.common;

public class ObjectHolder<T> {

    private T ref;

    public ObjectHolder(T ref) {
        this.ref = ref;
    }

    public T getValue() {
        return ref;
    }

    public void setValue(T ref) {
        this.ref = ref;
    }

    public String toString() {
        return ref.toString();
    }

}
