package uz.uat.app.intercom.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.channels.Channel;
import uz.uat.app.intercom.model.entity.messages.Draft;
import uz.uat.app.intercom.model.entity.messages.DraftRepository;
import uz.uat.app.intercom.model.entity.messages.Message;
import uz.uat.app.intercom.model.entity.messages.MessageRepository;

@Service
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepo;
    private DraftRepository draftRepo;

    public Message saveMessage(Message message) {
        return messageRepo.save(message);
    }

    public Message saveDraft(Draft draft) {
        return draftRepo.save(draft);
    }

    public void deleteMessage(Message message) {
        messageRepo.delete(message);
    }

    public void deleteDraft(Draft draft) {
        draftRepo.delete(draft);
    }

    public List<Message> findAllMessages() {
        return StreamSupport.stream(messageRepo.findAll().spliterator(), false).toList();
    }

    public List<Draft> findAllDrafts() {
        return StreamSupport.stream(draftRepo.findAll().spliterator(), false).toList();
    }

    public List<Message> findMessagesByChannel(Channel channel) {
        return StreamSupport.stream(messageRepo.findByChannel(channel.getArangoId()).spliterator(), false).toList();
    }

    public List<Draft> findDraftsByChannel(Channel channel) {
        return StreamSupport.stream(draftRepo.findByChannel(channel.getArangoId()).spliterator(), false).toList();
    }

    public Message newMessage(Channel channel, Account account, String text) {
        Message message = new Message();
        message.setChannel(channel);
        message.setAccount(account);
        message.setMessage(text);
        return message;
    }

}
