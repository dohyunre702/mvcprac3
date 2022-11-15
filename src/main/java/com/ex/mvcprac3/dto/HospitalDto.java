package com.ex.mvcprac3.dto;

import com.ex.mvcprac3.domain.Hospital;
import lombok.*;
import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class HospitalDto {
    private Integer id;
    private String open_service_name;
    private Integer open_local_government_code;
    private String management_number;
    private Timestamp license_date;
    private Integer business_status;
    private Integer business_status_code;
    private String phone;
    private String full_address;
    private String road_name_address;

    private String hospitalName;
    private String business_type_name;
    private Integer healthcare_provider_count;
    private Integer patient_room_count;
    private Integer total_number_of_beds;
    private float total_area_size;

    public Hospital toEntity() {
        return new Hospital(this.id, this.open_service_name, this.open_local_government_code,
                this.management_number, this.license_date, this.business_status,
                this.business_status_code, this.phone, this.full_address,
                this.road_name_address, this.hospitalName, this.business_type_name,
                this.healthcare_provider_count, this.patient_room_count, this.total_number_of_beds,
                this.total_area_size);
    }
}