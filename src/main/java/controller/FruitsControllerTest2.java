package controller;

import model.Fruits;
import org.springframework.web.HttpRequestHandler;
import service.FruitsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FruitsControllerTest2 implements HttpRequestHandler {

    private FruitsService fruitsService = new FruitsService();

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        String jsonInfo = convertListToJson(fruitsList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonInfo);
    }

    private String convertListToJson(List<Fruits> fruitsList) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Fruits fruits : fruitsList) {
            builder.append("{");
            builder.append("\"name\":\"").append(fruits.getName()).append("\",");
            builder.append("\"price\":\"").append(fruits.getPrice()).append("\",");
            builder.append("\"producing_area\":\"").append(fruits.getProducing_area()).append("\"");
            builder.append("},");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
