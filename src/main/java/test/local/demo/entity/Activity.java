package test.local.demo.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author hellohill
 * @date 2019/11/14 9:40 PM
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Activity {
  @Id private Integer id;
  private String username;
  private String title;
  private String content;
  private String time;

  public Activity(String username, String title, String content, String time) {
    this.username = username;
    this.title = title;
    this.content = content;
    this.time = time;
  }
}
