package uz.uat.app.intercom.views.panels;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import uz.uat.app.intercom.controller.AccountService;

public class AccountPanel extends HorizontalLayout {
    private AccountService service;

    public AccountPanel(AccountService service) {
        this.service = service;
    }



    
}
