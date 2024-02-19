package uz.uat.app.intercom.views.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.utils.UIData;
import uz.uat.app.intercom.utils.UIKeys;
import uz.uat.app.intercom.views.account.AccountView;

@Route("")
public class LoginView extends VerticalLayout {
    private AccountService service;
    private Button register;

    public LoginView(AccountService service) {
        this.service = service;
        register();
        setAlignItems(FlexComponent.Alignment.CENTER);
        add(loginForm(), register);
    }

    private LoginForm loginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            if (authenticate(event.getUsername(), event.getPassword())) {
                loginForm.setEnabled(false);
                Notification.show("Login successful");
            } else {
                Notification.show("Incorrect email or password");
                UI.getCurrent().navigate(AccountView.class);
            }
        });
        return loginForm;
    }

    private void register() {
        this.register = new Button("Регистрация");
        register.addClickListener(click -> {
            UI.getCurrent().navigate(AccountView.class);
        });
    }

    private boolean authenticate(String email, String password) {
        Account account = service.login(email, password);
        if (account != null) {
            UIData.setAttribute(UIKeys.ACCOUNT, account);
            return true;
        }
        return false;
    }
}
