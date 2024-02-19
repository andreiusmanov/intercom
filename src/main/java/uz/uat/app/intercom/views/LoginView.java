package uz.uat.app.intercom.views;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginView extends VerticalLayout {

    public LoginView() {
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            if (authenticate(event.getUsername(), event.getPassword())) {
                loginForm.setEnabled(false);
                Notification.show("Login successful");
            } else {
                Notification.show("Incorrect email or password");
            }
        });

        setAlignItems(FlexComponent.Alignment.CENTER);
        add(loginForm);
    }

    private boolean authenticate(String email, String password) {
        // Add your authentication logic here
        // Return true if authentication is successful, false otherwise
        return email.equals("user@example.com") && password.equals("password");
    }
}

