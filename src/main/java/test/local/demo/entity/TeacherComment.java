package test.local.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author 张娟娟
 * @date 2019/10/11 10:02 AM
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TeacherComment {
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "teacher_id")
  private Integer teacherId;

  private String time;
  private String content;

  public TeacherComment(String username, Integer teacherId, String time, String content) {
    this.username = username;
    this.teacherId = teacherId;
    this.time = time;
    this.content = content;
  }
}
