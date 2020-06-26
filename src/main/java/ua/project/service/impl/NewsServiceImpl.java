package ua.project.service.impl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ua.project.dao.NewsDAO;
import ua.project.model.news.News;
import ua.project.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsDAO newsDAO;

    public NewsServiceImpl(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @Override
    @Transactional
    public Set<News> getNews(Integer count) {
        return newsDAO.getNews(count);
    }

    @Override
    @Transactional
    public News getNewsById(Integer id) {
        return newsDAO.getNewsById(id);
    }

    @Override
    @Transactional
    public List<News> getLastAddedNews(Integer count) {
        return newsDAO.getLastAddedNews(count);
    }

    @Override
    @Transactional
    public void addNews(News news) {
        this.newsDAO.addNews(news);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        this.newsDAO.updateNews(news);
    }

    @Override
    @Transactional
    public void deleteNews(Integer id) {
        this.newsDAO.deleteNews(id);
    }
}
