package uz.uat.app.intercom.views.account;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.account.Department;
import uz.uat.app.intercom.views.AdminLayout;

@PageTitle("Пользователи")
@Route(value = "intercom/accounts", layout = AdminLayout.class)
public class AccountView extends VerticalLayout {

    private AccountService service;
    private GridCrud<Account> crud;

    public AccountView(AccountService service) {
        this.service = service;
        crud();
        add(crud);
    }

    private void crud() {
        this.crud = new GridCrud<>(Account.class);
        crud.setAddOperation(service::saveAccount);
        crud.setUpdateOperation(service::saveAccount);
        crud.setDeleteOperation(service::deleteAccount);
        crud.setFindAllOperation(service::findAllAccounts);

        Grid<Account> grid = crud.getGrid();
        grid.setColumns("name", "surname", "patronymic", "position", "department.shortName", "login", "password");
        grid.getColumnByKey("name").setHeader("Имя");
        grid.getColumnByKey("surname").setHeader("Фамилия");
        grid.getColumnByKey("patronymic").setHeader("Отчество");
        grid.getColumnByKey("position").setHeader("Должность");
        grid.getColumnByKey("department.shortName").setHeader("Подразделение");
        grid.getColumnByKey("login").setHeader("Логин");
        grid.getColumnByKey("password").setHeader("Пароль");

        crud.getCrudFormFactory().setFieldCaptions("Имя", "Фамилия", "Отчество", "Должность", "Подразделение", "Логин",
                "Пароль");
        crud.getCrudFormFactory().setVisibleProperties("name", "surname", "patronymic", "position", "department",
                "login", "password");

        crud.getCrudFormFactory().setFieldProvider("department", (combobox) -> {
            ComboBox<Department> d = new ComboBox<>("Подразделение", service.findAllDepartments());
            d.setItemLabelGenerator(item -> item.getCode() + " - " + item.getShortName());
            return d;
        });

    }

}
