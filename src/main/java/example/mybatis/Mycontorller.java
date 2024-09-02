package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class Mycontorller {

    @Autowired private Myservice myservice;

    @GetMapping("/findall")
    public List<UserDto> findAll(){
        return myservice.findAll();
    }

    @GetMapping("/find")
    public UserDto findByid(int id){
        return myservice.findByid(id);
    }

    @PostMapping("/save")
    public int save(UserDto userDto){
        return myservice.save(userDto);
    }

    @PutMapping("/update")
    public int update(UserDto userDto){
        return myservice.update(userDto);
    }

    @DeleteMapping("/delete")
    public int delete(int id){
        return myservice.delete(id);
    }

}
