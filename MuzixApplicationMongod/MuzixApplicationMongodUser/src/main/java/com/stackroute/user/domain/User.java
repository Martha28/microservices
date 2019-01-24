package com.stackroute.user.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// if we use lombok plugin we can use plugins
@Document(value="UserMongod")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //instead of getter,setter,allargs,noargs we can use @Data
@ToString
public class User {

    @Id
    private int id;
    @ApiModelProperty(notes = "Name of the User")
    private String name;
    @ApiModelProperty(notes = "Comments")
    private String comment;

    public User(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }
}
