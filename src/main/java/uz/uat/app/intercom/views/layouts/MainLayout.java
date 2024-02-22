package uz.uat.app.intercom.views.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.controller.ChannelService;
import uz.uat.app.intercom.controller.MessageService;
import uz.uat.app.intercom.views.anew.center.MessagePanel;
import uz.uat.app.intercom.views.anew.header.Header;
import uz.uat.app.intercom.views.anew.right.RightPanel;

@Route("")

public class MainLayout extends AppLayout {
    private AccountService accountService;
    private ChannelService channelService;
    private MessageService messageService;

    private Header header;
    private RightPanel channels;
    private MessagePanel messagePanel;

    public MainLayout(AccountService accountService, ChannelService channelService, MessageService messageService) {
        this.accountService = accountService;
        
        
        // Set up the header, right panel, and message panel
        header = new Header();
        channels = new RightPanel();
        messagePanel = new MessagePanel();

        // Create a vertical layout for the drawer content
        VerticalLayout drawerContent = new VerticalLayout();
        drawerContent.add(channels);

        // Add the drawer toggle button to the header
        DrawerToggle drawerToggle = new DrawerToggle();
        header.add(drawerToggle);

        // Create a Div to hold the main content
        Div content = new Div();
        content.setSizeFull();
        content.add(messagePanel);

        // Create a main layout as a vertical layout
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.add(header, content);

        // Set the drawer content and main layout as the content of the AppLayout
        setDrawerOpened(false);
        addToDrawer(drawerContent);
        setContent(mainLayout);
    }
}