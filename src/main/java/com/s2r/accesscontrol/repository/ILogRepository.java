package com.s2r.accesscontrol.repository;

import com.s2r.accesscontrol.model.entity.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogRepository extends JpaRepository<LogModel, Long> {

}