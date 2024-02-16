package uz.uat.app.intercom.model.entity;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uz.uat.app.intercom.controller.repo.ChatRepository;

@Service
@AllArgsConstructor
public class ChatService {
private ChatRepository chatRepo;


public Chat save(Chat chat){
    return chatRepo.save(chat);
}

public void delete(Chat chat){
    chatRepo.delete(chat);
}

public List<Chat> findAll(){
    return StreamSupport.stream(chatRepo.findAll().spliterator(), false).toList();
}




public List<Chat> find(String chatType){
    return chatRepo.findByType(chatType);
}





}
