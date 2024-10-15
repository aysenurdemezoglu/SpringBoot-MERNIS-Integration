package com.example.FirstTask.repository;

import com.example.FirstTask.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}
