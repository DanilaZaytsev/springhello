package ru.dzaytsev.msg.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import ru.dzaytsev.msg.entity.RecipientEntity;

public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {
}
