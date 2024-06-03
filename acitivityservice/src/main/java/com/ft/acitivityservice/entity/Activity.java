package com.ft.acitivityservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "activity_type",nullable = false)
    private String activityType;

    @Column(nullable = false)
    private int duration;

    private float distance;
    private String intensity;
    private int caloriesBurned;
    private LocalDateTime timestamp;
}
