package uz.uat.app.intercom.views.account;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.model.entity.account.Account;
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
        grid.setColumns("code", "shortName", "name");
        grid.getColumnByKey("code").setHeader("Код");
        grid.getColumnByKey("shortName").setHeader("Аббрев.");
        grid.getColumnByKey("name").setHeader("Наименование");

        crud.getCrudFormFactory().setFieldCaptions("Код", "Аббрев.", "Наименование");
        crud.getCrudFormFactory().setVisibleProperties("code", "shortName", "name");

crud.getCrudFormFactory().setFieldType(null, null);


    }

}
