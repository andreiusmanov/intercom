package uz.uat.app.intercom.views.layouts;

import java.util.List;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import uz.uat.app.intercom.controller.ChannelService;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.channels.Channel;

public class ChannelsView extends VerticalLayout {
    private ChannelService service;
    private Account account;
    List<Channel> channels;

    public ChannelsView(ChannelService service, Account account) {
        this.service = service;
        channels = service.findByAccount(account);
        channels.stream().forEach(channel -> this.add(createCard(channel)));
    }

    private HorizontalLayout createCard(Channel person) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        Image image = new Image();
        image.setSrc(person.getImage());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(person.getName());
        name.addClassName("name");
        Span date = new Span(person.getStartDate().toString());
        date.addClassName("date");
        header.add(name, date);

        Span post = new Span(person.getStatus());
        post.addClassName("post");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        Icon likeIcon = VaadinIcon.HEART.create();
        likeIcon.addClassName("icon");
        Span likes = new Span(person.getStatus());
        likes.addClassName("likes");
        Icon commentIcon = VaadinIcon.COMMENT.create();
        commentIcon.addClassName("icon");
        Span comments = new Span(person.getStatus());
        comments.addClassName("comments");
        Icon shareIcon = VaadinIcon.CONNECT.create();
        shareIcon.addClassName("icon");
        Span shares = new Span(person.getStatus());
        shares.addClassName("shares");

        actions.add(likeIcon, likes, commentIcon, comments, shareIcon, shares);

        description.add(header, post, actions);
        card.add(image, description);
        return card;
    }

}
