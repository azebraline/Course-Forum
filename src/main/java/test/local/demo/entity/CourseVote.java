package test.local.demo.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/10/11 3:27 PM
 */
@Data
@AllArgsConstructor
public class CourseVote {
  @Id private Integer id;
  private Integer course_id;
  private String username;

  public CourseVote(Integer course_id, String username) {
    this.course_id = course_id;
    this.username = username;
  }
}
