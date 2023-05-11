package springnews.dao;

import springnews.model.News;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<News, Long> {
    News findByTitle(String title);
}