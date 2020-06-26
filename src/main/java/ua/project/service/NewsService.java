package ua.project.service;

import ua.project.model.news.News;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface NewsService {

    Set<News> getNews(Integer count);

    News getNewsById(Integer id);

    List<News> getLastAddedNews(Integer count);

    void addNews(News news);

    void updateNews(News news);

    void deleteNews(Integer id);
}
