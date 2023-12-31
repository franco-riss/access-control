package com.s2r.accesscontrol.repository;

import com.s2r.accesscontrol.model.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByTagsContains(String tag);
    boolean existsByTagsIn(List<String> tags);
}