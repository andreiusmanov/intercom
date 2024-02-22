package uz.uat.app.intercom.views.anew.center;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextArea;

import uz.uat.app.intercom.controller.MessageService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.channels.Channel;
import uz.uat.app.intercom.model.entity.messages.Message;
import uz.uat.app.intercom.utils.UIData;
import uz.uat.app.intercom.utils.UIKeys;

public class MessagePanel extends Div {
    private MessageService service;
    private Channel channel;
    private Account account;
    private Grid<MessageComponent> grid;
    private TextArea messageArea;

    public MessagePanel() {
        this.channel = (Channel) UIData.getAttribute(UIKeys.CHANNEL);
        this.account = (Account) UIData.getAttribute(UIKeys.ACCOUNT);
        grid();
        messageArea();
        add(grid, messageArea);
    }

    private void messageArea() {
        this.messageArea = new TextArea();
    }

    private void grid() {
        this.grid = new Grid<>(MessageComponent.class);
        grid.setItems(createMessageComponents(getMessages(channel)));

    }

    private List<Message> getMessages(Channel channel) {
        return  new ArrayList<Message>(0);// service.findMessagesByChannel(channel);
    }

    private Message newMessage(String draft) {
        return service.saveMessage(service.newMessage(this.channel, this.account, draft));
    }

    private List<MessageComponent> createMessageComponents(List<Message> messages) {
        List<MessageComponent> components = new ArrayList<>(0);
        messages.stream().forEach(message -> {
            MessageComponent c = new MessageComponent(message);
            components.add(c);
        });
        return components;
    }
}
