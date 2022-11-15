package com.ex.mvcprac3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "nation_wide_hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital {

    @Id//id를 이미 생성해서 넣은 상태. GeneratedValue 사용안함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //column에 여러 옵션을 정해 줄 수 있다. ex.컬럼명(기본값 외 컬럼 정하기)
    private String open_service_name;
    private Integer open_local_government_code;
    private String management_number;
    private Timestamp license_date;
    private Integer business_status;
    private Integer business_status_code;
    private String phone;
    private String full_address;
    private String road_name_address;

    @Column(name="hospital_name")
    private String hospitalName;

    private String business_type_name;
    private Integer healthcare_provider_count;
    private Integer patient_room_count;
    private Integer total_number_of_beds;
    private float total_area_size;
}
