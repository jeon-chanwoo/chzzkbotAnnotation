package org.dendrocopos.chzzkbot.core.api;

import lombok.Builder;//롬복 잊지말자 getter setter등을 자동으로 달아준다.
import lombok.Getter;

@Builder
@Getter
public class ApiBody<T> {//API바디 데이터와 메세지가 있다.
    private T data;
    private T msg;
}
