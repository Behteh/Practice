package com.revature.novel.models;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "novel")
@Getter
@Setter
public class Novel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int novel_id;
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL)
    private Set<FictionalCharacter> fictionalCharacter;

    public Novel() {
        super();
    }

    public Novel(int novel_id, String title) {
        super();
        this.novel_id = novel_id;
        this.title = title;
    }
}

