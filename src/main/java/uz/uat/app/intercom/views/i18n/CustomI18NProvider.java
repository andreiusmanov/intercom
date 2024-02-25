package uz.uat.app.intercom.views.i18n;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.flow.i18n.I18NProvider;

public class CustomI18NProvider implements I18NProvider {

    private static final List<Locale> providedLocales = Arrays.asList(Locale.ENGLISH, Locale.GERMAN);

    @Override
    public List<Locale> getProvidedLocales() {
        return providedLocales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.getString(key);
    }

    public boolean hasTranslation(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.containsKey(key);
    }

}
