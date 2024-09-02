package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Myservice {

    @Autowired private MyDao myDao;

    public List<UserDto> findAll(){
        return myDao.findAll();
    }

    public int save(UserDto userDto){
        return myDao.save(userDto);
    }

    public int update(UserDto userDto){
        return myDao.update(userDto);
    }

    public int delete(int id){
        return myDao.delete(id);
    }

    public UserDto findByid(int id){
        return myDao.findByid(id);
    }
}
