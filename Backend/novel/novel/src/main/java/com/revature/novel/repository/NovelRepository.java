package com.revature.novel.repository;

import com.revature.novel.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NovelRepository extends JpaRepository<Novel, Integer>{

    public Optional<Novel> findNovelByTitle(String title);

    public Optional<Novel> getNovel_Id(int novel_id);

}
