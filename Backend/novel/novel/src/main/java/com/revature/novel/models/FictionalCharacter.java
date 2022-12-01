package com.revature.novel.models;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fictional_character")
@Getter
@Setter
public class FictionalCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_id;
    private String name;
    private int novel_id;

    @ManyToOne
    @JoinColumn(name="novel_id", referencedColumnName="id")
    private Novel novel;

    public FictionalCharacter() {
        super();
    }

    public FictionalCharacter(int character_id, String name, int novel_id) {
        super();
        this.character_id = character_id;
        this.name = name;
        this.novel_id = novel_id;
    }
}
