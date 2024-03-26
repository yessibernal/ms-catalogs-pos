package com.innter.mscatalogspos.repositories;

import com.innter.mscatalogspos.entities.PresentationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends JpaRepository<PresentationEntity, Long> {
}
