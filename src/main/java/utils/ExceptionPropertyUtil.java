package utils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ExceptionPropertyUtil {

    private Properties prop;
    private InputStream fis;

    private void init() throws IOException {
        prop = new Properties();
        String path = getClass().getClassLoader().getResource("/exceptionMapping.properties").getPath();
        fis = new BufferedInputStream(new FileInputStream(path));
//            fis = getClass().getResourceAsStream("/exceptionMapping.properties");
        //prop.load(fis);//直接这么写，如果properties文件中有汉子，则汉字会乱码。因为未设置编码格式。
        prop.load(new InputStreamReader(fis, "utf-8"));
        fis.close();
    }

    public String getExceptionMsg(String ExceptionCode) {
        String msg;
        try {
            init();
            msg = prop.getProperty(ExceptionCode);
        } catch (IOException e) {
            msg = ExceptionCode;
        }
        if (StringUtil.isNotBlank(msg)) {
            return msg;
        } else {
            return "未定义异常";
        }
    }
}
