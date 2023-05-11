package springnews.service;

import springnews.dao.NewsDao;
import springnews.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springnews.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Override
    public News findUserById(long filmId) {
        Optional<News> userFromDb = newsDao.findById(filmId);
        return userFromDb.orElse(new News());
    }
    @Override
    public List<News> allNews() {
        return newsDao.findAll();
    }
    @Override
    public News getById(long id) {
        return newsDao.getById(id);
    }
    @Override
    public void delete(Long newsId) {
        newsDao.deleteById(newsId);
    }

    @Override
    public void save(News news) {
        news.setTitle(news.getTitle());
        news.setDescription(news.getDescription());
        newsDao.save(news);
    }
}