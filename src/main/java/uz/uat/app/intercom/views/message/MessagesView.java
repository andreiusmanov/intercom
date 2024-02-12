package uz.uat.app.intercom.views.message;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import uz.uat.app.intercom.views.Main;

@PageTitle("UAT Интерком")
@Route(value = "messages-board", layout = Main.class)
@RouteAlias(value = "", layout = Main.class)
public class MessagesView extends Div implements AfterNavigationObserver{

    public MessagesView(){
        add(new H3("Hello"));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent arg0) {
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'afterNavigation'");
    }
}
