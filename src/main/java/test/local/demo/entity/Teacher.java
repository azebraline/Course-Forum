package test.local.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "teacher")
@Data
@AllArgsConstructor
public class Teacher {
  @Id
  @Column(name = "id")
  private Integer id;

  private String name;
  private String gender;
  private String title;
  private String introduction;

  public Teacher(String name, String gender, String title, String introduction) {
    this.name = name;
    this.gender = gender;
    this.title = title;
    this.introduction = introduction;
  }

  @Override
  public String toString() {
    return "Teacher{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", title='"
        + title
        + '\''
        + ", introduction='"
        + introduction
        + '\''
        + '}';
  }
}
