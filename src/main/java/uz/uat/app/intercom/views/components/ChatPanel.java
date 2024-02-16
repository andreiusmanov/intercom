package uz.uat.app.intercom.views.components;

import java.util.List;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import uz.uat.app.intercom.model.entity.Chat;

public class ChatPanel extends VerticalLayout {

    public ChatPanel() {
    }

    public void populateChats(List<Chat> chats) {
        this.removeAll();
        chats.stream().forEach(chat -> {
            this.add(createCard(chat));
        });
    }

    private HorizontalLayout createCard(Chat chat) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
        Image image = new Image();
        image.setSrc(chat.getImage());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(chat.getName());
        name.addClassName("name");
        header.add(name);

        return card;
    }

}
