package com.chaitanya.urlshortner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String longUrl;
   private String shortUrl;

   public Long getId(){
       return id;
   }

   public void setLongUrl(String longUrl){
       this.longUrl=longUrl;
   }
   public String getLongUrl(){
       return longUrl;
   }

   public void setShortUrl(String shortUrl){
       this.shortUrl=shortUrl;
   }
   public String getShortUrl(){
       return shortUrl;
   }
}
