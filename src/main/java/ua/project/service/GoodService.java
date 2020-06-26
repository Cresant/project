package ua.project.service;

import ua.project.model.good.Good;

import java.util.Set;

public interface GoodService {

    public Good getGoodById(Integer id);

    public Good getGoodById(Integer id, Boolean active);

    public Set<Good> getAllGoods();

    public Set<Good> getGoods(Integer count, Boolean active);

    public Set<Good> getLastAddedGoods(Integer count, Boolean active);

    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId, Boolean active);

    void addGood(Good good);

    void updateGood(Good good);

    void deleteGood(Integer id);
}
