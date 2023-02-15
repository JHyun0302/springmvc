package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 둘다 허용 /hello-basic, /hello-basic/
     * 메서드 따로 설정 안해서 모두 허용 (GET, HEAD, POST, PUT, PATCH, DELETE)
     */
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑 -http://localhost:8080/mapping-param?mode=debug (쿼리 파라미터가 있어야 매핑됨!)
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑 - header 정보에 <mode, debug>가 있어야 매핑 가능
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type - Content-Type이 "application/json"이여야 매핑 가능
     * * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE) //"application/json"
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type - Accpet가 "text/html"과 관련이 있어야 매핑 가능
     * * produces = "text/html"
     * produces = "!text/html"
     * * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE) // "text/html"
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
