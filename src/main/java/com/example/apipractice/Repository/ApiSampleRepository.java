package com.example.apipractice.Repository;

import com.example.apipractice.Model.ApiSampleModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiSampleRepository {

    ApiSampleModel findById(Integer id);

    void insertTopic(ApiSampleModel model);

    void updateTopic(ApiSampleModel model);

    void deleteTopic(Integer id);
}
