package uz.uat.app.intercom.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.utils.UIData;
import uz.uat.app.intercom.utils.UIKeys;
import uz.uat.app.intercom.views.about.AboutView;
import uz.uat.app.intercom.views.helloworld.HelloWorldView;

import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MessageLayout extends AppLayout {

    private H2 viewTitle;
    private MenuBar menu;
    private Account account;

    public MessageLayout() {
        setPrimarySection(Section.DRAWER);
        account = (Account) UIData.getAttribute(UIKeys.ACCOUNT);
        addDrawerContent();
        addHeaderContent();

    }

    private void menu() {
        this.menu = new MenuBar();
        menu.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        menu.addItem(VaadinIcon.USERS.create(), "Личные каналы",
                event -> Notification.show("Не внедрено", 3000, Position.MIDDLE));
        menu.addItem(VaadinIcon.WORKPLACE.create(), "Служебные каналы",
                event -> Notification.show("Не внедрено", 3000, Position.MIDDLE));
        menu.addItem(VaadinIcon.INFO_CIRCLE_O.create(), "Информация",
                (ComponentEventListener<ClickEvent<MenuItem>>) event -> Notification.show("Не внедрено", 3000,
                        Position.MIDDLE));
        menu.addItem(VaadinIcon.CHAT.create(), "Роботы",
                (ComponentEventListener<ClickEvent<MenuItem>>) event -> Notification.show("Не внедрено", 3000,
                        Position.MIDDLE));
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        menu();
        Avatar avatar = createAvatar(account);
        addToNavbar(true, toggle, viewTitle, menu, avatar);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Intercom");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

    private Avatar createAvatar(Account account){
        Avatar a = new Avatar(account.getLogin());
        return a;
    }
}
