package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        return "response/hello"; //@Controller + String 반환: return값이 view의 논리적 주소가
    }

    @RequestMapping("/response/hello") //v2의 return값(view의 논리적 주소)과 @RequestMapping이 같으면 void 써도 됨 -> 권장 X
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
