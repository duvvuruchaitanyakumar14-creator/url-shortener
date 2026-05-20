package com.chaitanya.urlshortner.controller;

import com.chaitanya.urlshortner.entity.Url;
import com.chaitanya.urlshortner.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @ResponseBody
    @PostMapping("/shorten")
    public Url shortenUrl(
            @RequestParam String longUrl
    ) {
        return urlService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortUrl:[a-zA-Z0-9]+}")
    public String redirect(
            @PathVariable String shortUrl
    ) {

        Url url =
                urlService.getOriginalUrl(shortUrl);

        if (url == null) {
            return "redirect:/index.html";
        }

        return "redirect:" +
                url.getLongUrl();
    }
}