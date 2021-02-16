package com.safetyas.sds.common.entity;

import com.safetyas.sds.common.model.MemberBoardCommentDto;
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
@Table(name = "sds_member_board_comment")
public class MemberBoardComment extends CommonEntity implements Serializable {

  @Builder
  public MemberBoardComment(Long commentSeq, String category, String title,
      String writer, String writerEmail, String content, LocalDateTime inDate, Integer viewCount,
      LocalDateTime modDate, LocalDateTime delDate) {
    super(inDate, modDate, delDate);
    this.commentSeq = commentSeq;
    this.category = category;
    this.title = title;
    this.writer = writer;
    this.writerEmail = writerEmail;
    this.content = content;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_seq", nullable = false, length = 20)
  private Long commentSeq;

  @Column(name = "category", nullable = false, length = 100)
  private String category;

  @Column(name = "title", nullable = false, length = 250)
  private String title;

  @Column(name = "writer", nullable = false, length = 100)
  private String writer;

  @Column(name = "writer_email", nullable = false)
  private String writerEmail;

  @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
  private String content;

  @Column(name = "view_count")
  private Integer viewCount;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_seq", foreignKey = @ForeignKey(name = "member_seq_member_board_comment_fk"))
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "member_board_seq", foreignKey = @ForeignKey(name = "member_board_seq_member_board_comment_fk"))
  private MemberBoard memberBoard;

  public void updateMemberBoardComment(MemberBoardCommentDto commentDto){
    this.category = commentDto.getCategory();
    this.title = commentDto.getTitle();
    this.content = commentDto.getContent();
    this.writer = commentDto.getWriter();
    this.writerEmail = commentDto.getWriterEmail();
  }

  public void updateMemberBoard(MemberBoard memberBoard) {
    if (this.memberBoard != null) {
      this.memberBoard.getMemberBoardCommentList().remove(this);
    }
    this.memberBoard = memberBoard;
    memberBoard.getMemberBoardCommentList().add(this);
  }

  public void updateMember(Member member) {
    if (this.member != null) {
      this.member.getMemberBoardCommentList().remove(this);
    }
    this.member = member;
    member.getMemberBoardCommentList().add(this);
  }

}
