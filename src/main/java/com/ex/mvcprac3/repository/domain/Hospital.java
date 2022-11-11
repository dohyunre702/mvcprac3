package com.ex.mvcprac3.repository.domain;

import javax.persistence.*;

@Entity
@Table(name = "nation_wide_hospitals")
public class Hospital {
    @Id//id를 이미 생성해서 넣은 상태. GeneratedValue 사용안함
    private Integer id; //적절한 type
    private String open_service_name;
    private Integer open_local_government_code;
    private String management_number;
    private java.sql.Date license_date;
    private short business_status;
    private short business_status_code;
    private String phone;
    private String full_address;
    private String road_name_address;
    private String hospital_name;
    private String business_type_name;
    private Integer healthcare_provider_count;
    private Integer patient_room_count;
    private Integer total_number_of_beds;
    private Double total_area_size;

}
