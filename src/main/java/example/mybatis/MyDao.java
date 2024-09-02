package example.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface MyDao {

    //[1] 추상메소드

    // 전체출력
    List<UserDto> findAll();
    // 등록
    int save(UserDto userDto);
    // 수정
    int update(UserDto userDto);
    //삭제
    int delete(int id);
}
