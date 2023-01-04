package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller: return값 == view 이름
 * @RestController: return값 == String (html에 바로 찍힘)
 */

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); //@Slf4j: lombok이 대신해줌

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name); //log.info(" info log={}, {}", name, name2); -> {}값이랑 name 치환됨
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
