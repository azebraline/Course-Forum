package test.local.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/10/9 2:48 PM
 */
@Data
@Table(name = "courses")
@AllArgsConstructor
public class Course {
  @Id
  @Column(name = "id")
  private Integer id;

  private String name;

  @Column(name = "vote")
  private Integer vote;

  @Column(name = "dislike")
  private Integer dislike;

  private String introduction;

  @Column(name = "teacher_id")
  private Integer teacherId;

  public Course(String name, int teacherId, String introduction) {
    this.name = name;
    this.vote = 0;
    this.teacherId = teacherId;
    this.dislike = 0;
    this.introduction = introduction;
  }

  @Override
  public String toString() {
    return "Course{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", teacherId="
        + teacherId
        + ", vote="
        + vote
        + ", dislike="
        + dislike
        + ", introduction='"
        + introduction
        + '\''
        + '}';
  }
}
