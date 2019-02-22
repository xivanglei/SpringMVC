package controller;

import model.Fruits;
import model.UserAndProductQryModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FruitsService;
import validator.group.FruitsGroup1;

import java.util.List;

@Controller
@RequestMapping("/query")
public class FindControllerTest {

    private FruitsService fruitsService = new FruitsService();

    @RequestMapping(value = "queryFruitsByCondition")
    public String queryFruitsByCondition(Model model, @Validated(value = FruitsGroup1.class) Fruits fruits,
                                         BindingResult bindingResult) {
        List<ObjectError> allErrors = null;
        if(bindingResult.hasErrors()) {
            allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
        }
        List<Fruits> findList = null;
        if(fruits == null ||
                (fruits.getName() == null && fruits.getProducing_area() == null)) {
            findList = fruitsService.queryFruitsList();
        } else {
            findList = fruitsService.queryFruitsByCondition(fruits);
        }
        model.addAttribute("fruitsList", findList);
        model.addAttribute("allErrors", allErrors);
        return "/fruits/findFruits";
    }

    @RequestMapping("fruitsArrayTest")
    public String FruitsArray(Model model, int[] fids) {
        model.addAttribute("fruitsList", fruitsService.queryFruitsList());
        if(fids != null)
        for(int i = 0; i < fids.length; i++) {
            System.out.println("fids[" + i + "]=" + fids[i]);
        }
        return "/fruits/fruitsArray";
    }

    //实现RESTful风格
    @RequestMapping(value = "queryFruit/{id}", method = {RequestMethod.GET})
    public @ResponseBody Fruits getFruitById(Model model, @PathVariable("id") Integer fruitId) throws Exception {
        Fruits fruit = fruitsService.queryFruitById(fruitId);
        return fruit;
    }
}
