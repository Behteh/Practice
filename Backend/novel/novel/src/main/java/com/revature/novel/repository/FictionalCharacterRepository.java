package com.revature.novel.repository;

import com.revature.novel.models.FictionalCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FictionalCharacterRepository extends JpaRepository<FictionalCharacter, Integer> {

    public FictionalCharacter findByName(String Name);

    public Optional<FictionalCharacter> findFCByNovel_id(int novel_id);

}
