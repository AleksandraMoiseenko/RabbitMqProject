package entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarvelHero implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String origin;

}
