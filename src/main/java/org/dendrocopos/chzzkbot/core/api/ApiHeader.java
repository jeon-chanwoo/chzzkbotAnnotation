package org.dendrocopos.chzzkbot.core.api;

import lombok.Builder;//롬복은 어노테이션만 달면 생성자와getter setter등을 자동으로 달아준다.
import lombok.Getter;

@Builder
@Getter
public class ApiHeader {//API헤더 파일 resultcode와 codename이 들어있다.
    private int resultCode;
    private String codeName;
}
