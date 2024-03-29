package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * header 정보 log 출력
 */
@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale, //언어 정보
                          @RequestHeader MultiValueMap<String, String> headerMap, // MultiValueMap = 1개 key에 여러 value 받기 가능 <keyA=val1 & keyA=val2>
                          @RequestHeader("Host") String host22, //특정 HTTP 헤더 조회
                          @CookieValue(value = "myCookie", required = false) String cookie // value: 쿠키 이름, required=false (없어도 됨)
    ) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host22);
        log.info("myCookie={}", cookie);

        return "ok";
    }

}
