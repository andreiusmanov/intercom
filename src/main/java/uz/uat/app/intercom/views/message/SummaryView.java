package uz.uat.app.intercom.views.message;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.views.MessageLayout;

@PageTitle(value = "UAT Интерком")
@Route(value = "intercom/summary", layout = MessageLayout.class)
public class SummaryView extends VerticalLayout {

    public SummaryView() {
        add(new Anchor("intercom/messages", "Messages"));
    }
}
