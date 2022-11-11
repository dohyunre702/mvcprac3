package com.ex.mvcprac3.domain;

import javax.persistence.*;

@Entity
@Table(name = "nation_wide_hospitals")
public class Hospital {
    @Id//id를 이미 생성해서 넣은 상태. GeneratedValue 사용안함
    private Integer id; //적절한 type

}
