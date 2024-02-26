package uz.uat.app.intercom.views.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

import uz.uat.app.intercom.controller.AccountService;
import uz.uat.app.intercom.controller.ChannelService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.utils.UIData;
import uz.uat.app.intercom.utils.UIKeys;

/**
 * The main view is a top-level placeholder for other views.
 */
public class IntercomLayout extends AppLayout {

    private H2 viewTitle;
    private ChannelService channelService;
    //private AccountService accountService;
    private Account account;

    public IntercomLayout(ChannelService channelService, AccountService accountService) {
        this.channelService = channelService;
      //  this.accountService = accountService;
        this.account = accountService.findById("accounts/1474945");
        UIData.setAttribute(UIKeys.ACCOUNT, account);
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
        setContent(new MessagesView());
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
       
        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Intercom");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);
        ChannelsView channels = new ChannelsView(channelService, account);
        Scroller scroller = new Scroller(channels);

        addToDrawer(header, scroller, createFooter());
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
}
