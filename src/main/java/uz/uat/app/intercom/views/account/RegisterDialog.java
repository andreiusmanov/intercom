package uz.uat.app.intercom.views.account;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.account.Department;
import uz.uat.app.intercom.utils.UIData;
import uz.uat.app.intercom.utils.UIKeys;
import uz.uat.app.intercom.views.login.LoginView;

@PageTitle("Пользователь")
@Route(value = "intercom/register")
public class RegisterDialog extends Dialog {
    private AccountService service;
    private FormLayout form;
    private Account account = new Account();
    private Binder<Account> binder;
    private TextField name = new TextField("Имя");
    private TextField surname = new TextField("Фамилия");
    private TextField patronymic = new TextField("Отчество");
    private TextField login = new TextField("Логин");
    private PasswordField password = new PasswordField("Пароль");
    private TextField position = new TextField("Должность");
    private ComboBox<Department> department = new ComboBox<>("Отдел");
    private TextField telephone = new TextField("Служебн. тел");
    private Button register;
    private Button cancel;

    public RegisterDialog(AccountService service) {
        this.service = service;
        form();
        binder();
        buttons();
        setHeaderTitle("Регистрация нового пользователя");
        getFooter().add(register, cancel);
        add(form);
    }

    private void buttons() {
        this.register = new Button("Сохранить");

        this.register.addClickListener(click -> {
            try {
                Account a = binder.getBean();
                service.saveAccount(a);
                Notification.show("Данные пользователя " + a.getLogin() + " сохранены", 5, Position.MIDDLE);
                this.close();
                UI.getCurrent().navigate(LoginView.class);
            } catch (Exception e) {
            }
        });
        this.cancel = new Button("Отменить");
        this.cancel.addClickListener(click -> {
            this.close();
            UI.getCurrent().navigate(LoginView.class);
        });

    }

    private void binder() {
        this.binder = new Binder<>(Account.class);
        binder.setBean(account);
        binder.bindInstanceFields(this);
    }

    private void form() {
        this.form = new FormLayout();
        form.setSizeUndefined();
        name = new TextField("Имя");
        surname = new TextField("Фамилия");
        patronymic = new TextField("Отчество");
        login = new TextField("Логин");
        password = new PasswordField("Пароль");
        position = new TextField("Должность");
        telephone = new TextField("Служебн. тел");
        department = new ComboBox<>("Отдел");
        department.setItems(service.findAllDepartments());
        department.setItemLabelGenerator((dept) -> dept.getCode() + " - " + dept.getShortName());
        form.add(surname, name, patronymic, position, department, telephone, login, password);
    }

}
