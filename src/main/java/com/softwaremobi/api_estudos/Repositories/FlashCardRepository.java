package com.softwaremobi.api_estudos.Repositories;

import com.softwaremobi.api_estudos.Models.FlashCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlashCardRepository extends MongoRepository<FlashCardModel, String> {
}
