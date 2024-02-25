package uz.uat.app.intercom.utils;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;

public class UIData {

    public static boolean hasValue(String key) {
        return VaadinSession.getCurrent().getAttribute(key) != null;
    }

    public static void setAttribute(String key, Object value) {
        VaadinSession.getCurrent().setAttribute(key, value);
    }

    public static Object getAttribute(String key) {
        boolean res = hasValue(key);
        if (res) {
            VaadinSession.getCurrent().getAttribute(key);
        }
        return null;
    }

}
