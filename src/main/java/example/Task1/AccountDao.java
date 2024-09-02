package example.Task1;


import example.mybatis.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    //c
    int put(AccountDto accountDto);
    //r
    List<AccountDto> find();
    //u
    int update(AccountDto accountDto);
    //d
    int delete(int id);
}
