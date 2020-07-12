package com.g16.healthpay.mapper;

import com.g16.healthpay.model.Feedback;

public interface FeedbackDao {
    int insert(Feedback record);

    int insertSelective(Feedback record);
}