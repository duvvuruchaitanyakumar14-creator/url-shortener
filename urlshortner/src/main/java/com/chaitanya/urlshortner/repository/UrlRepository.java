package com.chaitanya.urlshortner.repository;

import com.chaitanya.urlshortner.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url,Long> {
    Url findByShortUrl(String shortUrl);

}
