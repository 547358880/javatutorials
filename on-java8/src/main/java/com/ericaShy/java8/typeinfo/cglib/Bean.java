package com.ericaShy.java8.typeinfo.cglib;

import java.beans.PropertyChangeListener;

public abstract class Bean {

    String sampleProperty;

    abstract public void addPropertyChangeListener(PropertyChangeListener listener);

    abstract public void removePropertyChangeListener(PropertyChangeListener listener);

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String sampleProperty) {
        this.sampleProperty = sampleProperty;
    }

    @Override
    public String toString() {
        return "sampleProperty is " + sampleProperty;
    }
}
