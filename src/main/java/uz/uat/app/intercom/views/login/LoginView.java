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
import uz.uat.app.intercom.views.account.RegisterDialog;
import uz.uat.app.intercom.views.department.DepartmentView;
import uz.uat.app.intercom.views.message.MessagesView;
import uz.uat.app.intercom.views.message.SummaryView;

@Route("")
public class LoginView extends VerticalLayout {
    private AccountService service;
    private Button register;
    private Button admin;
    private RegisterDialog dialog;

    public LoginView(AccountService service) {
        this.service = service;
        register();
        admin();
        setAlignItems(FlexComponent.Alignment.CENTER);
        add(loginForm(), register, admin);
    }

    private void admin() {
        this.admin = new Button("Администрирование");
        admin.addClickListener(click -> {
            UI.getCurrent().navigate(DepartmentView.class);
        });
    }

    private LoginForm loginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(event -> {
            if (authenticate(event.getUsername(), event.getPassword())) {
                loginForm.setEnabled(false);
                UI.getCurrent().navigate(LoginView.class);
                
                Notification.show("Авторизация пройдена");
            } else {
                Notification.show("Email и/или пароль не найдены");
            }
        });
        return loginForm;
    }

    private void register() {
        this.register = new Button("Регистрация");
        register.addClickListener(click -> {
            RegisterDialog rv = new RegisterDialog(service);
            rv.setCloseOnEsc(true);
            rv.open();
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
