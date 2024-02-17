package uz.uat.app.intercom.views;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.theme.lumo.LumoUtility;

import uz.uat.app.intercom.model.entity.Chat;
import uz.uat.app.intercom.model.entity.ChatService;
import uz.uat.app.intercom.model.entity.chats.ChanelTypes;
import uz.uat.app.intercom.views.components.ChatPanel;
import uz.uat.app.intercom.views.components.ChatsView;

public class MainAddLayout extends AppLayout {
    private ChatService service;
    private H2 viewTitle;
    private ChatPanel chatPanel;
    private MenuBar menu;
    private MenuBar menu2;
    private MenuItem chatItem;

    public MainAddLayout(ChatService service) {
        this.service = service;
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();

    }

    private void addDrawerContent() {
        chatPanel = new ChatPanel();
        chatPanel.populateChats(findChats(ChanelTypes.DEPT));
        addToDrawer(chatPanel);
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
        menu2();
        addToNavbar(true, toggle, viewTitle, menu, menu2);
    }

    private void menu() {
        this.menu = new MenuBar();
        menu.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        MenuItem botItem = menu.addItem("bot");
        botItem.addClickListener(click -> chatPanel.populateChats(findChats(ChanelTypes.ROBOT)));
        MenuItem infoItem = menu.addItem("info");
        infoItem.addClickListener(click -> chatPanel.populateChats(findChats(ChanelTypes.INFO)));
        MenuItem deptItem = menu.addItem("department");
        deptItem.addClickListener(click -> chatPanel.populateChats(findChats(ChanelTypes.DEPT)));
        MenuItem commonItem = menu.addItem("common");
        commonItem.addClickListener(click -> chatPanel.populateChats(findChats(ChanelTypes.USER)));
    }

    private void menu2() {
        this.menu2 = new MenuBar();
        getElement().setProperty("style", "justify-content: flex-end;");
        menu2.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        this.chatItem = menu2.addItem(VaadinIcon.COG.create());
        chatItem.addClickListener(click -> {
            UI.getCurrent().navigate(ChatsView.class);
        });
    }

    private List<Chat> findChats(String chatType) {
        return service.find(chatType);
    }

}
