package test.local.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/10/9 2:48 PM
 */
@Data
@AllArgsConstructor
public class CourseDTO {
  private Integer id;
  private String name;
  private Integer vote;
  private Integer dislike;
  private String introduction;
  private Integer teacherId;
  private String teacherName;

  public CourseDTO(
      String name,
      Integer vote,
      Integer dislike,
      String introduction,
      Integer teacherId,
      String teacherName) {
    this.name = name;
    this.vote = vote;
    this.dislike = dislike;
    this.introduction = introduction;
    this.teacherId = teacherId;
    this.teacherName = teacherName;
  }
}
