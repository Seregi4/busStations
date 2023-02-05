package com.levanov.busstations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Direct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code")
    private Integer code;


    public Direct(Integer code) {
        this.code = code;
    }
}
