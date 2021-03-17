package com.safetyas.sds.common.repository.info;

import com.safetyas.sds.common.entity.info.InfoHazardGrade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoHazardGradeRepository extends JpaRepository<InfoHazardGrade, String> {
  public List<InfoHazardGrade> findAllByOrderByHazardGradeKeyAsc();
}
