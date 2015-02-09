package com.ssungatov.test.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;


public class FacesUtils {
    public static void addFacesMessage(String messageKey) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(bundleMessage(messageKey)));

    }

    public static String bundleMessage(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        String text = "";
        ResourceBundle bundle = ResourceBundle.getBundle("com/ssungatov/test/message", context.getViewRoot().getLocale());
        text = bundle.getString(key);
        return text;
    }

}
