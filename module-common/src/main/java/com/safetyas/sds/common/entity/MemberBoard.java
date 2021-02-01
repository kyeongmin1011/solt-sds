package com.safetyas.sds.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "sds_member_board")
public class MemberBoard extends CommonEntity implements Serializable {

  @Builder
  public MemberBoard(Member member, Long memberBoardSeq, String category, String title,
      String writer, String writerEmail, String content, LocalDateTime inDate,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    setMember(member);
    this.memberBoardSeq = memberBoardSeq;
    this.category = category;
    this.title = title;
    this.writer = writer;
    this.writerEmail = writerEmail;
    this.content = content;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_board_seq", nullable = false, length = 20)
  private Long memberBoardSeq;

  @Column(name = "category", nullable = false, length = 100)
  private String category;

  @Column(name = "title", nullable = false, length = 250)
  private String title;

  @Column(name = "writer", nullable = false, length = 100)
  private String writer;

  @Column(name = "writer_email", nullable = false, length = 255)
  private String writerEmail;

  @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
  private String content;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_board_fk"))
  private Member member;

  public void setMember(Member member) {
    if (this.member != null) {
      this.member.getMemberBoardList().remove(this);
    }
    this.member = member;
    member.getMemberBoardList().add(this);
  }

}
