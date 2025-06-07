package com.softwaremobi.api_estudos.Repositories;

import com.softwaremobi.api_estudos.Models.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<TaskModel, String> {
}
