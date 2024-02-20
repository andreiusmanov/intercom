package uz.uat.app.intercom.views.account;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

@PageTitle("Пользователь")
@Route(value = "intercom/account2")
public class AccountView2 extends VerticalLayout {
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

    public AccountView2(AccountService service) {
        this.service = service;
        this.account = (Account) UIData.getAttribute(UIKeys.ACCOUNT);
        form();
        binder();
        add(form);
    }

    private void binder() {
        this.binder = new Binder<>(Account.class);
        binder.setBean(account);
        binder.bindInstanceFields(this);
    }

    private void form() {
        this.form = new FormLayout();
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.EVENLY);
        form.setSizeUndefined();
        name = new TextField("Имя");
        surname = new TextField("Фамилия");
        patronymic = new TextField("Отчество");
        login = new TextField("Логин");
        password = new PasswordField("Пароль");
        position = new TextField("Должность");
        department = new ComboBox<>("Отдел");
        department.setItems(service.findAllDepartments());
        department.setItemLabelGenerator((dept) -> dept.getCode() + " - " + dept.getShortName());
        form.setColspan(department, 2);
        form.add(name, surname, patronymic, position, department, login, password);
    }

}
