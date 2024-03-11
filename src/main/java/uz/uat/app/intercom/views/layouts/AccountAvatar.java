package uz.uat.app.intercom.views.layouts;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;

import uz.uat.app.intercom.model.entity.account.Account;

public class AccountAvatar extends Button {

    private Account account;

    public AccountAvatar() {
        Avatar avatar = new Avatar();
        this.setIcon(avatar);
        this.getStyle().set("cursor", "pointer");

        this.addClickListener(event -> {
            // handle the click event here
            Notification.show("Avatar clicked!");
        });
        this.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.getStyle()
                .set("border-radius", "50%")
                .set("padding", "0");

    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
