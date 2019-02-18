package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.UserValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserControllerTest {

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping("toLogin")
    public String toLoginPage() {
        return "/user/login";
    }

    @RequestMapping("login")
    public String login(Model model, @Valid User user, BindingResult result) {
        List<ObjectError> allErrors = null;
        if(result.hasErrors()) {
            allErrors = result.getAllErrors();
            for(ObjectError objectError : allErrors) {
                System.out.println("code=" + objectError.getCode() + "  DefaultMessage=" + objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors", allErrors);
            return "/user/login";
        } else {
            return "/user/loginSuccess";
        }
    }
}
