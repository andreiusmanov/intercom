package uz.uat.app.intercom.views.anew.center;

import com.vaadin.flow.component.html.Div;

import uz.uat.app.intercom.model.entity.messages.Message;

public class MessageComponent extends Div {
    private String text;

    public MessageComponent(Message message) {
        this.text = message.getMessage();
        add(text);
    }

}
