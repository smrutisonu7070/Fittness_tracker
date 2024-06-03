package com.ft.acitivityservice.controller;

import com.ft.acitivityservice.payloads.ActivityDto;
import com.ft.acitivityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> logActivity(@RequestBody ActivityDto activity) {
        ActivityDto loggedActivity = activityService.logActivity(activity);
        return ResponseEntity.ok(loggedActivity);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityDto>> getActivities(@PathVariable Long userId) {
        List<ActivityDto> activities = activityService.getActivities(userId);
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityDto> getActivity(@PathVariable Long activityId) {
        ActivityDto activity = activityService.getActivity(activityId);
        return ResponseEntity.ok(activity);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Long activityId, @RequestBody ActivityDto updatedActivity) {
        ActivityDto activity = activityService.updateActivity(activityId, updatedActivity);
        return ResponseEntity.ok(activity);
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
        activityService.deleteActivity(activityId);
        return ResponseEntity.noContent().build();
    }
}
