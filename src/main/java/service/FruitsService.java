package service;

import model.Fruits;

import java.util.ArrayList;
import java.util.List;

public class FruitsService {

    List<Fruits> mFruitsList = queryFruitsList();

    public List<Fruits> queryFruitsList() {
        List<Fruits> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruits(1,"红富士苹果", 2.3, "山东"));
        fruitsList.add(new Fruits(2,"香蕉", 1.5, "上海"));
        return fruitsList;
    }

    public Fruits queryFruitById(int id) {
        Fruits fruits = null;
        for(Fruits fruit : mFruitsList) {
            if(fruit.getId() == id) {
                fruits = fruit;
                break;
            }
        }
        return fruits;
    }

    public List<Fruits> queryFruitsByCondition(Fruits fruits) {
        String name = fruits.getName();
        String area = fruits.getProducing_area();
        List<Fruits> queryList = new ArrayList<>();
        for(Fruits f : mFruitsList) {
            if((!name.equals("") && f.getName().contains(name)) ||
                    (!area.equals("") && f.getProducing_area().contains(area)) ||
                    (f.getName().contains(name) && f.getProducing_area().contains(area))) {
                queryList.add(f);
            }
        }
        return queryList.size() > 0 ? queryList : null;
    }
}
