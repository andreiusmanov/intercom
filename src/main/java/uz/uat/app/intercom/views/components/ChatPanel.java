package uz.uat.app.intercom.views.components;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;

public class ChatPanel extends Accordion{


public ChatPanel(){
    add(new AccordionPanel("All Chats"));
    add(new AccordionPanel("Recent Chats"));
    add(new AccordionPanel("Info Chats"));
}


}
