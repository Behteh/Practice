package com.revature.novel.service;

import com.revature.novel.Exception.NovelNotFoundException;
import com.revature.novel.models.Novel;
import com.revature.novel.repository.NovelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NovelService {

    private final NovelRepository novelRepository;

    public NovelService(NovelRepository novelRepository) {this.novelRepository = novelRepository;
    }

    public Optional<Novel> findByTitle(String title) {
        return novelRepository.findNovelByTitle(title);
    }

    public Novel getNovelById(Integer novel_id) throws NovelNotFoundException {
        Optional<Novel> optionalNovel = novelRepository.findById(novel_id);
        if (optionalNovel.isPresent())
            return optionalNovel.get();
        else
            throw new NovelNotFoundException("No existing Novel");
    }

    public Novel updateNovel(Integer novel_id, Novel update) throws NovelNotFoundException {
        Novel existingNovel = getNovelById(novel_id);

        if (update.getTitle()!=null)
            existingNovel.setTitle(update.getTitle());
        System.out.println(update);
        System.out.println(existingNovel);
        novelRepository.save(existingNovel);
        return existingNovel;
    }

    public Novel save(Novel novel) {
        return novelRepository.save(novel);
    }
}
