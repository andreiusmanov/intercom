package uz.uat.app.intercom.views.panels;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import uz.uat.app.intercom.model.entity.channels.Channel;
import uz.uat.app.intercom.views.layouts.ChannelComponent;

public class ChannelsPanel extends VerticalLayout {
    private List<ChannelComponent> channelComponents;
    private MessagesPanel messagesView;

    public ChannelsPanel(MessagesPanel messagesView) {
        this.channelComponents = new ArrayList<ChannelComponent>(0);
        this.messagesView = messagesView;
    }

    public List<ChannelComponent> getChannelComponents() {
        return channelComponents;
    }

    public void setChannelComponents(List<Channel> channels) {
        this.channelComponents.clear();
        for (Channel channel : channels) {
            ChannelComponent channelComponent = new ChannelComponent(channel, messagesView);
            channelComponents.add(channelComponent);
            add(channelComponent);
        }
    }
}