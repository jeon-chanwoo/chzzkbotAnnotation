package org.dendrocopos.chzzkbot.core.api;

import org.dendrocopos.chzzkbot.core.utils.ErrorCode;

public class ApiResponse<T> {//제네릭 타입의 객체를 만들어준다.
    private ApiHeader header;//헤더와
    private ApiBody body;//바디인데 이것도 하나의 객체로 만들어 준것이다.
    private static int SUCCESS = 200;//성공코드는 200

    public ApiResponse(ApiHeader header) {//생성자인데 헤더만 있는 생성자
        this.header = header;
    }

    public ApiResponse(ApiHeader header, ApiBody body) {//생성자인데 헤더와 바디가 다 있는 생성자이다.
        this.header = header;
        this.body = body;
    }

    public static <T> ApiResponse<T> OK(T data) {//앞쪽의 <T>는 이 메서드가 제너릭 타입이란걸 알려준다.
    											//메서드가 호출될때 다양한 타입으로 처리할 수 있도록 한다.
    											//뒤쪽의 <T>는반환타입으로써 매서드를 호출할때 사용
        return new ApiResponse<>(			
                ApiHeader.builder()
                	.resultCode(SUCCESS)
                	.codeName("SUCCESS")
                	.build()
                ,ApiBody.builder()
                	.data(data)
                	.msg(null)
                	.build()
        );
    }

    public static <T> ApiResponse<T> FAIL(ErrorCode errorCode) {
        return new ApiResponse<>(
                ApiHeader.builder()
                	.resultCode(errorCode.getCode())
                	.codeName(errorCode.name())
                	.build()
                ,ApiBody.builder()
                	.data(null)
                	.msg(errorCode.getMessage())
                	.build()
        );
    }
}
