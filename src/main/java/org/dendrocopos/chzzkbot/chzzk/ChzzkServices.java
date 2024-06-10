package org.dendrocopos.chzzkbot.chzzk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChzzkServices {

    private final WebClient webClient;

    @Value("${Chzzk.URL.chzzkBaseURL}")//bin폴더에 저장(아마 여기에 주로사던지 UID같은걸 저장하는거 같다)
    String chzzkBaseURL;
    @Value("${Chzzk.URL.gameBaseURL}")
    String gameBaseURL;
    @Value("${Chzzk.NID_AUT}")
    String nidAut;
    @Value("${Chzzk.NID_SES}")
    String nidSes;
    @Value("${spring.application.version}")
    String applicationVersion;

    public ChzzkServices(WebClient webClient) {//get,head등 정보를 가지고 온다. 생성자
        this.webClient = webClient;
    }

    public Mono<String> reqChzzk(String path) {//CHZZK API에 GET 요청을 보내고, JSON 응답을 Mono<String>으로 반환합니다.
        return webClient.get()
                .uri( chzzkBaseURL + path)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.COOKIE, "NID_AUT=" + nidAut + ";NID_SES=" + nidSes)
                .header(HttpHeaders.USER_AGENT, "guribot/" + applicationVersion + " (SpringBoot)")
                .retrieve()
                .bodyToMono(String.class);// 응답 본문을 Mono<String>으로 변환합니다.
    }
    
 // reqChzzk 메서드를 호출하여 상태를 가져오는 메서드입니다.
    public Mono<String> getStatus(String path) {
        return reqChzzk(path);
    }

    public Mono<String> reqGame(String path){
        return webClient.get()
                .uri( gameBaseURL + path)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.COOKIE, "NID_AUT=" + nidAut + ";NID_SES=" + nidSes)
                .retrieve()
                .bodyToMono(String.class);// 응답 본문을 Mono<String>으로 변환합니다.
    }
}
