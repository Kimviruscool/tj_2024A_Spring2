package example.log;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Log4j2

public class Logcontroller {

    @Autowired private Logservice logservice;

    @GetMapping("")
    public void log(){
        log.debug("LogController debug log");
        log.info("LogController info log");
        log.warn("LogController warn log");
        log.error("LogController error log");
        log.fatal("LogController fatal log");
        logservice.log();
    }

}
