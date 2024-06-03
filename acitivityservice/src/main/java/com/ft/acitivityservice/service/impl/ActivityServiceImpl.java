package com.ft.acitivityservice.service.impl;

import com.ft.acitivityservice.entity.Activity;
import com.ft.acitivityservice.payloads.ActivityDto;
import com.ft.acitivityservice.repository.ActivityRepo;
import com.ft.acitivityservice.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepo activityRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ActivityDto logActivity(ActivityDto activity) {
        Activity savedActivity = this.activityRepo.save(modelMapper.map(activity,Activity.class));
        return modelMapper.map(savedActivity,ActivityDto.class);
    }

    public List<ActivityDto> getActivities(Long userId) {
        List<Activity> activities = activityRepo.findByUserId(userId);
        return this.modelMapper.map(activities, List.class);
    }

    public ActivityDto getActivity(Long activityId) {
        Activity activity = activityRepo.findById(activityId).orElse(null);
        return this.modelMapper.map(activity, ActivityDto.class);
    }

    public void deleteActivity(Long activityId) {
        activityRepo.deleteById(activityId);
    }

    public ActivityDto updateActivity(Long activityId, ActivityDto activity) {
        if (activityRepo.existsById(activityId)) {
            activity.setActivityId(activityId);
            Activity updatedActivityDb = activityRepo.save(modelMapper.map(activity,Activity.class));
            return this.modelMapper.map(updatedActivityDb, ActivityDto.class);
        }
        return null;
    }
}
