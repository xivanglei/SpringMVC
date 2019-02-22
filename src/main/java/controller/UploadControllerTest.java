package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import utils.StringUtil;

import java.io.File;
import java.util.UUID;

@Controller
public class UploadControllerTest {

    @RequestMapping("toUploadPage")
    public String toUploadPage(Model model) throws Exception {
        return "/ImgUploadTest";
    }

    @RequestMapping("uploadImg")
    public String uploadImg(Model model, MultipartFile file) throws Exception {
        if(file == null)
            return "/ImgUploadTest";
        //上传图片的原始名称
        String originalFilename = file.getOriginalFilename();
        String newFilename = null;
        if (StringUtil.isNotEmpty(originalFilename)) {
            String pic_path = "/Users/xianglei/upload/";
            newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(pic_path + newFilename);
            file.transferTo(newFile);
        }
        model.addAttribute("image", newFilename);
        return "/ImgUploadTest";
    }
}
