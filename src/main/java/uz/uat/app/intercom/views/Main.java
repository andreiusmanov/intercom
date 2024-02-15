package uz.uat.app.intercom.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.theme.lumo.LumoUtility;

import uz.uat.app.intercom.views.components.ChatPanel;

public class Main extends AppLayout {
    private H2 viewTitle;
    private MenuBar menu;
    private MenuItem infoItem;
    private MenuItem botItem;
    private MenuItem deptItem;
    private MenuItem commonItem;

    public Main() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();

    }

    private void addDrawerContent() {
        ChatPanel panel = new ChatPanel();
        addToDrawer(panel);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'decorateDrawer'");
        setPrimarySection(Section.NAVBAR);
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        menu();

        addToNavbar(true, toggle, viewTitle, menu);
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
