package uz.uat.app.intercom.views.message;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import uz.uat.app.intercom.views.Main;

@PageTitle("Hello World")
@Route(value = "hello message", layout = Main.class)
@RouteAlias(value = "", layout = Main.class)
public class MessagesView extends VerticalLayout{

    public MessagesView(){
        add(new H3("Hello"));
    }
}
