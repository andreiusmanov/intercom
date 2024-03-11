package uz.uat.app.intercom.views.panels;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderPanel extends HorizontalLayout {

    private H4 title;

    public HeaderPanel() {
        this.title = new H4("Заголовок канала");
        add(title);
    }

    public void setHeaderText(String text) {
        this.title.setText(text);
    }
}
