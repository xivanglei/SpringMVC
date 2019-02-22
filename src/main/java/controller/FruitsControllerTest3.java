package controller;

import model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.FruitsService;

import java.util.List;

//使用@Controller来标识它是一个控制器
@Controller
public class FruitsControllerTest3 {

    private FruitsService fruitsService = new FruitsService();

    @RequestMapping("/queryFruits")
    public ModelAndView queryFruitsList() throws Exception {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitsList", fruitsList);
        modelAndView.setViewName("/fruits/fruitsList");
        return modelAndView;
    }

}
