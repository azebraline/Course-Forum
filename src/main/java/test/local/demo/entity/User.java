package test.local.demo.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/9/25 4:21 PM
 */
@Data
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {
  @Id private String username;
  private String password;
  private boolean enabled;
}
