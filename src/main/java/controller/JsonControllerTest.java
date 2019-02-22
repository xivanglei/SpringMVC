package controller;

import model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonControllerTest {

    Log log = LogFactory.getLog(getClass());

    @RequestMapping("toJsonTestPage")
    public String toUploadPage(Model model) throws Exception {
        return "/JsonTest";
    }

    //测试Json数据 通过@RequestBody转换成实体，通过@ResponseBody返回Json字符串
    @RequestMapping("JsonTest")
    public @ResponseBody User JsonTest(@RequestBody User user) {
        log.info("userInfo[username:" + user.getUsername() + ",password:" + user.getPassword() + "]");
        return user;
    }

    //接收键值对,不需要@RequestBody注解 返回 Json字符串
    @RequestMapping("KeyValueTest")
    public @ResponseBody User keyValueTest(User user) {
        log.info("userInfo[username:" + user.getUsername() + ",password:" + user.getPassword() + "]");
        return user;
    }
}
