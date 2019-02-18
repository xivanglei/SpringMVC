package controller;

import model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.FruitsService;

import java.util.List;

//使用@Controller来标识它是一个控制器
@Controller
@RequestMapping("/test")
public class FruitsControllerTest4 {

    private FruitsService fruitsService = new FruitsService();

    @RequestMapping("queryFruit")
    public String queryFruitById(Model model, @RequestParam(value = "fruit_id", required = true) Integer id) throws Exception {
        Fruits fruit = fruitsService.queryFruitById(id);
        model.addAttribute("fruit", fruit);
        return "/fruits/fruitsDetail";
    }
}
