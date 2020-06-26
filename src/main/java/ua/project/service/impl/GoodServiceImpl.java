package ua.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.project.dao.GoodDAO;
import ua.project.service.GoodService;
import ua.project.model.good.Good;

import java.util.Set;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDao;

    @Autowired
    public GoodServiceImpl(GoodDAO goodDao) {
        this.goodDao = goodDao;
    }

    @Override
    @Transactional
    public Good getGoodById(Integer id) {
        return goodDao.getGoodById(id);
    }

    @Override
    @Transactional
    public Good getGoodById(Integer id, Boolean active) {
        return goodDao.getGoodById(id, active);
    }

    @Override
    @Transactional
    public Set<Good> getAllGoods() {
        return goodDao.getAllGoods();
    }

    @Override
    @Transactional
    public Set<Good> getGoods(Integer count, Boolean active) {
        return goodDao.getGoods(count, active);
    }

    @Override
    @Transactional
    public Set<Good> getLastAddedGoods(Integer count, Boolean active) {
        return goodDao.getLastAddedGoods(count, active);
    }

    @Override
    @Transactional
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId, Boolean active) {
        return goodDao.getGoodsByCategory(count, categoryId, active);
    }

    @Override
    @Transactional
    public void addGood(Good good) {
        this.goodDao.addGood(good);
    }

    @Override
    @Transactional
    public void updateGood(Good good) {
        this.goodDao.updateGood(good);
    }

    @Override
    @Transactional
    public void deleteGood(Integer id) {
        this.goodDao.deleteGood(id);
    }
}
