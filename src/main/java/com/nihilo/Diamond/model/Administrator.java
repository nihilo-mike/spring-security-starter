package com.nihilo.Diamond.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

/*annotating it with entity so that a table can be created  */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
}
