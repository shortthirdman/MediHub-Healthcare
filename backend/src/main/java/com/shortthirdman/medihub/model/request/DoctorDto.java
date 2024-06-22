package com.shortthirdman.medihub.model.request;

import com.shortthirdman.medihub.common.enums.Specialization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private Long id;
    private String name;
    private Specialization specialization;
    private int yearsOfExperience;
    private String contactInformation;
    private String workingHours;
    private List<Long> appointmentIds;
}
