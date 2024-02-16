package uz.uat.app.intercom.model.entity.chats;

import com.google.common.collect.ImmutableList;

public class ChatTypes {
        public static final String USER_CHAT = "USER_CHAT";
        public static final String INFO_CHAT = "INFO_CHAT";
        public static final String ROBOT_CHAT = "ROBOT_CHAT";
        public static final String DEPT_CHAT = "DEPT_CHAT";

        public static ImmutableList<String> toList() {
                return ImmutableList.of(USER_CHAT, INFO_CHAT, ROBOT_CHAT, DEPT_CHAT);
        }
}
