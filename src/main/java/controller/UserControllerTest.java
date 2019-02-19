package controller;

import exception.UserException;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.StringUtil;
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
    public String login(Model model, @Valid User user, BindingResult result) throws Exception {

        if (checkBlackList(user)) {
            throw new UserException("user.not.have.power");
        }
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

    private boolean checkBlackList(User user) {
        String[] blackArray = {"jack", "tom", "jean"};
        for(String black : blackArray) {
            if (StringUtil.equals(user.getUsername(), black)) {
                return true;
            }
        }
        return false;
    }
}
