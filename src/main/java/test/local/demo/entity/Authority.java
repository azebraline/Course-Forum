package test.local.demo.entity;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张娟娟
 * @date 2019/9/29 3:29 PM
 */
@Data
@AllArgsConstructor
@Table(name = "authorities")
public class Authority {
  private String username;
  private String authority;
}
