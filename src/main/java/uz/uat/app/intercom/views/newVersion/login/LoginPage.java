package uz.uat.app.intercom.views.newVersion.login;

import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.server.VaadinSession;

public class LoginPage extends Div {

    public LoginPage() {
        // Get the UI locale
        Locale currentLocale = UI.getCurrent().getLocale();

        // Get the I18N provider from the Vaadin service
       // I18NProvider i18nProvider = new CustomI18NProvider();

        // Get the bundle for the current UI locale
        ResourceBundle bundle = ResourceBundle.getBundle("messages", currentLocale);

        // Create the login overlay
        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setOpened(true);
        loginOverlay.setTitle(bundle.getString("login.title"));
        loginOverlay.setDescription(bundle.getString("login.description"));
        loginOverlay.setForgotPasswordButtonVisible(false);
        loginOverlay.addLoginListener(e -> {
            // Here you can implement your authentication logic
            String username = e.getUsername();
            String password = e.getPassword();

            if (authenticate(username, password)) {
                // Authentication successful, redirect to secure page or logged-in state
                VaadinSession.getCurrent().setAttribute("authenticated", true);
                UI.getCurrent().navigate(LoggedInView.class);
            } else {
                // Authentication failed, show an error message in the login overlay
                loginOverlay.setError(true);
                //todo loginOverlay.setErrorText(bundle.getString("login.error"));
                loginOverlay.setTitle(bundle.getString("login.error"));
            }
        });

        // Attach the login overlay to the UI when the component is attached to the UI
        UI.getCurrent().addAttachListener(event -> {
            UI ui = event.getUI();
            ui.add(loginOverlay);
        });
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        // Clear the session attribute when the component is detached from the UI
        VaadinSession.getCurrent().setAttribute("authenticated", null);
    }

    private boolean authenticate(String username, String password) {
        // Implement your authentication logic here
        // Return true if authentication succeeds, false otherwise
        // You can connect to a database or any other authentication mechanism

        // For the sake of simplicity, let's assume the username is "admin" and the password is "admin"
        return "admin".equals(username) && "admin".equals(password);
    }
}
