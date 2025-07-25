package com.management.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate doe;
    private List<Long> courseIds;
}