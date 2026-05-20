package com.chaitanya.urlshortner.service;

import com.chaitanya.urlshortner.entity.Url;
import com.chaitanya.urlshortner.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository=urlRepository;
    }
    public Url shortenUrl(String longUrl){
        Url url=new Url();
        url.setLongUrl(longUrl);
        urlRepository.save(url);
        Long number=url.getId();
        String shortUrl=convertToBase62(number);
        url.setShortUrl(shortUrl);
        urlRepository.save(url);
        return url;
    }
    private String convertToBase62(Long url){
        String character =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl=new StringBuilder();
        while(url!=0){
            long temp=url/62;
            long remainder =url%62;
            shortUrl.append(character.charAt((int)remainder));
            url=temp;
        }
        return shortUrl.reverse().toString();
    }

    public Url getOriginalUrl(String shortUrl){
        return urlRepository.findByShortUrl(shortUrl);
    }
}
