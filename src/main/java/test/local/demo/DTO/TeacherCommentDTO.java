package test.local.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hellohill
 * @date 2019/11/14 4:33 PM
 */
@Data
@AllArgsConstructor
public class TeacherCommentDTO {
  String teachername;
  String username;
  String time;
  String content;
}
