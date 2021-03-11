package com.safetyas.sds.client.api.request;

import com.safetyas.sds.common.model.MemberBoardDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberBoardRequest {

  private Long memberBoardSeq;
  private String category;
  private String title;
  private String writerName;
  private String writerEmail;
  private String content;
  private List<MultipartFile> file;

  public MemberBoardDTO toDTO() {
    return MemberBoardDTO.builder()
        .category(this.category)
        .title(this.title)
        .writerName(this.writerName)
        .writerEmail(this.writerEmail)
        .content(this.content)
        .build();
  }
}
