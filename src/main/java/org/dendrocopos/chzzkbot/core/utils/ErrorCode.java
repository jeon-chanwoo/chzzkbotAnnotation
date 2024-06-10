package org.dendrocopos.chzzkbot.core.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    FAIL(999,"실패"),
    NOT_FOUND_USER(600,"NOT_FOUND_USER"),
    NOT_FOUND_TOKEN(601,"NOT_FOUND_TOKEN")
    ;

    ErrorCode(int code, String message) {//생성자는 호출될때 생성되니 생성자보다 아래에 정의 해줘도 된다.
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
