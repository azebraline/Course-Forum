package test.local.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hellohill
 * @date 2019/11/14 4:16 PM
 */
@Data
@AllArgsConstructor
public class CourseCommentDTO {
  private String coursename;
  private String username;
  private String time;
  private String content;
}
