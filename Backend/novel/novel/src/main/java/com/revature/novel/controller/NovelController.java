package com.revature.novel.controller;

import com.revature.novel.Exception.NovelNotFoundException;
import com.revature.novel.annotations.Authorized;
import com.revature.novel.models.Novel;
import com.revature.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/novel")
public class NovelController {

    private NovelService novelService;

    @Resource
    private HttpServletRequest request;

    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @Authorized
    @GetMapping
    public ResponseEntity<Object> getNovel(HttpSession session) throws NovelNotFoundException {
        Object uncheckedNovel = session.getAttribute("novel");
        if (uncheckedNovel instanceof Novel) {
            Novel novel = (Novel) uncheckedNovel.getClass().cast(uncheckedNovel);
            return ResponseEntity.ok(novelService.getNovelById(novel.getNovel_id()));
        } else {
            throw new ClassCastException("Invalid request: Expecting type 'Novel'");
        }
    }

    @Authorized
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNovel(@PathVariable("id") Integer novelId, @RequestBody Novel updateNovel) throws NovelNotFoundException {
        return ResponseEntity.ok(novelService.updateNovel(novelId, updateNovel));
    }

}