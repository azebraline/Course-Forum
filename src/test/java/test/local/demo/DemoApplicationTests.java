package test.local.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.local.demo.entity.Teacher;
import test.local.demo.mapper.TeacherMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
  @Autowired TeacherMapper teacherMapper;

  @Test
  public void contextLoads() {

    System.out.println("test");
    PageHelper.startPage(1, 3);
    PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teacherMapper.selectAll());
    System.out.println(pageInfo);
  }
}
