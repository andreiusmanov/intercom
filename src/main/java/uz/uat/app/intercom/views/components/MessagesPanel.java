package uz.uat.app.intercom.views.components;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.views.MainAddLayout;

@PageTitle(value = "Интерком UAT")
@Route(value = "messages", layout = MainAddLayout.class)
public class MessagesPanel extends VerticalLayout {

    private MenuBar menu;
    private MenuItem infoItem;
    private MenuItem botItem;
    private MenuItem deptItem;
    private MenuItem commonItem;

    public MessagesPanel() {
        menu();
    }

    private void menu() {
        this.menu = new MenuBar();
        menu.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        this.botItem = menu.addItem("bot");
        this.infoItem = menu.addItem("info");
        this.deptItem = menu.addItem("department");
        this.commonItem = menu.addItem("common");
    }

}
