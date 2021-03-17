package com.safetyas.sds.common.repository.info;

import com.safetyas.sds.common.entity.info.InfoPhrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPhraseRepository extends JpaRepository<InfoPhrase, Integer> {

}
