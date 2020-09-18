package test.local.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/10/11 10:02 AM
 */
@Data
@AllArgsConstructor
public class CourseComment {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "course_id")
  private Integer courseId;

  private String time;
  private String content;

  public CourseComment(String username, Integer courseId, String time, String content) {
    this.username = username;
    this.courseId = courseId;
    this.time = time;
    this.content = content;
  }
}
