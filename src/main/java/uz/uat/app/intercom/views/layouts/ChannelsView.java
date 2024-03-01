package uz.uat.app.intercom.views.layouts;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import uz.uat.app.intercom.model.entity.channels.Channel;

public class ChannelsView extends VerticalLayout {
    private List<ChannelComponent> channelComponents;
    private MessagesView messagesView;

    public ChannelsView(MessagesView messagesView) {
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