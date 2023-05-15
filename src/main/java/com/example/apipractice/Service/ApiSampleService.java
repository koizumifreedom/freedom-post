package com.example.apipractice.Service;

import com.example.apipractice.Model.ApiSampleModel;
import com.example.apipractice.Repository.ApiSampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApiSampleService {

 private final ApiSampleRepository apiSampleRepository;

 public ApiSampleModel findById(Integer id) {
  return apiSampleRepository.findById(id);
 }

 public ApiSampleModel addTopic(String title, String content) {
  ApiSampleModel model = new ApiSampleModel(title,content);
  apiSampleRepository.insertTopic(model);
  return model;
 }

 public ApiSampleModel updateTopic(Integer id, String title, String content) {
  ApiSampleModel model = new ApiSampleModel(id,title,content);
  apiSampleRepository.updateTopic(model);
  return model;
 }

 public ApiSampleModel deleteTopic(Integer id) {
  apiSampleRepository.deleteTopic(id);
  return findById(id);
 }
}