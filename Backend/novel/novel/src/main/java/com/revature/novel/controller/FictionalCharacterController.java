package com.revature.novel.controller;

import com.revature.novel.Exception.FictionalCharacterNotFoundException;
import com.revature.novel.annotations.Authorized;
import com.revature.novel.models.FictionalCharacter;
import com.revature.novel.service.FictionalCharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/fictional_character")
public class FictionalCharacterController {

    private FictionalCharacterService fictionalCharacterService;

    @Resource
    private HttpServletRequest request;

    public FictionalCharacterController(FictionalCharacterService fictionalCharacterService) {

        this.fictionalCharacterService = fictionalCharacterService;
    }

    @Authorized
    @GetMapping
    public ResponseEntity<Object> getFictionalCharacter(HttpSession session) throws FictionalCharacterNotFoundException {
        Object uncheckedFictionalCharacter = session.getAttribute("fictional_character");
        if (uncheckedFictionalCharacter instanceof FictionalCharacter) {
            FictionalCharacter fictionalCharacter = (FictionalCharacter) uncheckedFictionalCharacter.getClass().cast(uncheckedFictionalCharacter);
            return ResponseEntity.ok(fictionalCharacterService.findByName(fictionalCharacter.getName()));
        } else {
            throw new ClassCastException("Invalid request: Expecting type 'FictionalCharacter'");
        }
    }
    @Authorized
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFictionalCharacter(@PathVariable("id") Integer character_id, @RequestBody FictionalCharacter updateFictionalCharacter) throws FictionalCharacterNotFoundException {
        return ResponseEntity.ok(fictionalCharacterService.updateFictionalCharacter(character_id, updateFictionalCharacter));
    }
}
