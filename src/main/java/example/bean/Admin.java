package example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //get set 方法
@ToString //to string
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
public class Admin {
    private Integer id;
    private String account;
    private String password;

}
