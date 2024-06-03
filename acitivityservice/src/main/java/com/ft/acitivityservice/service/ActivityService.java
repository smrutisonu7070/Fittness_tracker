package com.ft.acitivityservice.service;

import com.ft.acitivityservice.entity.Activity;
import com.ft.acitivityservice.payloads.ActivityDto;

import java.util.List;

public interface ActivityService {

    public ActivityDto logActivity(ActivityDto activity);
    public List<ActivityDto> getActivities(Long userId);
    public ActivityDto getActivity(Long activityId);
    public void deleteActivity(Long activityId);
    public ActivityDto updateActivity(Long activityId, ActivityDto updatedActivity);
}
