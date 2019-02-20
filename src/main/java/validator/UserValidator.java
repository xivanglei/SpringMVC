package validator;

import model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import utils.StringUtil;

public class UserValidator implements Validator {

    //判断这实体类User是否支持校验
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    //校验
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "Username.is.empty", "用户名不能为空");
        User user = (User) o;
        if(StringUtil.isBlank(user.getPassword())) {
            errors.rejectValue("password", "Password.is.empty", "密码不能为空");
        } else if(user.getPassword().length() < 6) {
            errors.rejectValue("password", "length.too.short", "密码长度不得小于6位.");
        } else if(!checkUser(user)) {
            errors.rejectValue("password", "account.or.password.error", "账号密码错误");
        }
    }

    private boolean checkUser(User user) {
        if(StringUtil.equals(user.getUsername(),"zhangsan") && StringUtil.equals(user.getPassword(),"qwe123")) {
            return true;
        } else {
            return false;
        }
    }
}
