package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 정적 리소스: resources/static - 리소스를 보관하는 곳, 클래스패스의 시작 경로
 * 뷰 템플릿 사용
 */
@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; //@Controller + String 반환: return값 = view의 논리적 주소(templates/response/hello.html)
    }

    @RequestMapping("/response/hello") //v2의 return값(view의 논리적 주소)과 @RequestMapping이 같으면 void 써도 됨 -> 권장 X
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!!");
    }
}
