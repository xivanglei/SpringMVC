package controller;

import model.Fruits;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.FruitsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FruitsControllerTest implements Controller {

    private FruitsService fruitsService = new FruitsService();
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitsList", fruitsList);
        modelAndView.setViewName("/fruits/fruitsList");
        return modelAndView;
    }
}
