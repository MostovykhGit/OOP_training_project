package springnews.service;

import springnews.model.News;

import java.util.List;

public interface NewsService {
    News findUserById(long newsId);
    List<News> allNews();
    News getById(long id);
    void delete(Long newsId);

    void save(News news);
}
