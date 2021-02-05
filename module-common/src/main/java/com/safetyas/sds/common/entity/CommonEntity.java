package com.safetyas.sds.common.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonEntity implements Serializable {

  @Column(name = "in_date", updatable = false)
  @CreationTimestamp
  private LocalDateTime inDate;

  @Column(name = "mod_date")
  @UpdateTimestamp
  private LocalDateTime modDate;

  @Column(name = "del_date")
  private LocalDateTime delDate;

}
