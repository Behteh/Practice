package com.revature.novel.service;

import com.revature.novel.Exception.FictionalCharacterNotFoundException;
import com.revature.novel.models.FictionalCharacter;
import com.revature.novel.repository.FictionalCharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class FictionalCharacterService {

    private final FictionalCharacterRepository fictionalCharacterRepository;

    public FictionalCharacterService(FictionalCharacterRepository fictionalCharacterRepository) {
        this.fictionalCharacterRepository = fictionalCharacterRepository;
    }

    public FictionalCharacter findByName(String name){
        return fictionalCharacterRepository.findByName(name);
    }

    public FictionalCharacter updateFictionalCharacter(String name, FictionalCharacter update) throws FictionalCharacterNotFoundException{
        FictionalCharacter existingFictionalCharacter = findByName(name);

        if(update.getName()!=null)
            existingFictionalCharacter.setName(update.getName());
        System.out.println(update);
        System.out.println(existingFictionalCharacter);
        fictionalCharacterRepository.save(existingFictionalCharacter);
        return existingFictionalCharacter;
    }
}
