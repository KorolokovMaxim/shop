package com.korolkov.shop.repository.base;

import com.korolkov.shop.entity.base.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends AuditEntity> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {
    @Query("UPDATE #{#entityName} e SET e.deletedBy = ?2, e.deletedAt = ?3 WHERE e.id = ?1")
    @Modifying
    void deleteSoft(UUID id, String deletedBy, LocalDateTime deletedAt);
}