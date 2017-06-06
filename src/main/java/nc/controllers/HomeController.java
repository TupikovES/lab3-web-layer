package nc.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by petka on 24.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
public class HomeController {

    public static final Logger log = Logger.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(Model model) {
        log.info("Переход в " + HomeController.class.getName());
        model.addAttribute("title", "Welcome \"The Football Clubs\"");
        //String hi = hello.getHello();
        //model.addAttribute("hello", hi);
        return "home";
    }
}
