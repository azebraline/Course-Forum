package test.local.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hellohill
 * @date 2019/11/14 9:28 PM
 */
@Data
@AllArgsConstructor
public class VoteDTO {
  String username;
  String coursename;
}
