package org.dendrocopos.chzzkbot.chzzk;

import java.util.Objects;

public enum ChatCmd {
	//코드로 변환
    PING(0),
    PONG(10000),
    CONNECT(100),
    CONNECTED(10100),
    REQUEST_RECENT_CHAT(5101),
    RECENT_CHAT(15101),
    EVENT(93006),
    CHAT(93101),
    DONATION(93102),
    KICK(94005),
    BLOCK(94006),
    BLIND(94008),
    NOTICE(94010),
    PENALTY(94015),
    SEND_CHAT(3101);

    private final int value;

    ChatCmd(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Object getCommand(int value) { // 채팅을 받아와서 그에 맞는 코드로 변환
        for (ChatCmd cmd: values()) {
            if (Objects.equals(cmd.value, value)) {
                return cmd;
            }
        }
        return value;
    }

}
