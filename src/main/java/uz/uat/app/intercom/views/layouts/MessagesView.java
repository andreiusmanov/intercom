package uz.uat.app.intercom.views.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


@PageTitle("Intercom")
@Route(value = "intercom", layout = IntercomLayout.class)
@RouteAlias(value = "", layout = IntercomLayout.class)
public class MessagesView extends VerticalLayout {

}
