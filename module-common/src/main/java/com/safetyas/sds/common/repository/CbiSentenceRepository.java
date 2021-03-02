package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.CbiSentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CbiSentenceRepository extends JpaRepository<CbiSentence, Long> {

}
