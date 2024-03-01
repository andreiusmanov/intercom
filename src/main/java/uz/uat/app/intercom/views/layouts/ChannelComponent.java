package uz.uat.app.intercom.views.layouts;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import uz.uat.app.intercom.model.entity.channels.Channel;

public class ChannelComponent extends HorizontalLayout {
    private Channel channel;
    private Avatar avatar;
    private Text name;
    private MessagesView messagesView;

    public ChannelComponent(Channel channel, MessagesView messagesView) {
        this.channel = channel;
        this.avatar = new Avatar(channel.getName());
        this.name = new Text(channel.getName());


        this.getStyle().set("cursor", "pointer");

        this.addClickListener(event -> {
            // handle the click event here
            Notification.show("HorizontalLayout clicked!");
        });
        add(avatar, name);
    }

}
