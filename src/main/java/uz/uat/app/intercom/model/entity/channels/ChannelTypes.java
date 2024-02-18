package uz.uat.app.intercom.model.entity.channels;

import com.google.common.collect.ImmutableList;

public class ChannelTypes {
        public static final String USER = "USER";
        public static final String INFO = "INFO";
        public static final String ROBOT = "ROBOT";
        public static final String DEPT = "DEPT";

        public static ImmutableList<String> toList() {
                return ImmutableList.of(USER, INFO, ROBOT, DEPT);
        }
}
