package uz.uat.app.intercom.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uz.uat.app.intercom.model.entity.account.Account;
import uz.uat.app.intercom.model.entity.channels.Channel;
import uz.uat.app.intercom.model.entity.channels.ChannelRepository;

@Service
@AllArgsConstructor
public class ChannelService {
    private ChannelRepository channelRepo;

    public Channel save(Channel channel) {
        return channelRepo.save(channel);
    }

    
    public void delete(Channel channel) {
        channelRepo.delete(channel);
    }

    public List<Channel> findAll(Channel channel) {
        return StreamSupport.stream(channelRepo.findAll().spliterator(), false).toList();
    }

    public List<Channel> findByAccount(Account account){
        return channelRepo.findByAccount(account.getArangoId());
    }




}
