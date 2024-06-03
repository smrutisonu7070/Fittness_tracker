package com.ft.acitivityservice.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDto {

    private Long activityId;
    private Long userId;
    private String activityType;
    private int duration;
    private float distance;
    private String intensity;
    private int caloriesBurned;
    @JsonIgnore
    private LocalDateTime timestamp;
}
