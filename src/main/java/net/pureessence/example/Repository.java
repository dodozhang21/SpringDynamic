package net.pureessence.example;


import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Repository {
    @Autowired
    private Log log;

    public int methodOne(String arg1, String arg2, Type arg3) {
        log.info(String.format("methodOne with (String, String, Type) is invoked with (%s, %s, %s)",
                arg1,
                arg2,
                arg3)
        );
        return 1;
    }

    public int methodOne(String arg1, Integer arg2, Type arg3) {
        log.info(String.format("methodOne with (String, Integer, Type) is invoked with (%s, %s, %s)",
                arg1,
                arg2,
                arg3)
        );
        return 1;
    }

    public int methodTwo(String arg1, Type arg2, Integer arg3) {
        log.info(String.format("methodTwo with (String, Type, Integer) is invoked with (%s, %s, %s)",
                arg1,
                arg2,
                arg3)
        );
        return 2;
    }

    public int methodThree(Integer arg1, Integer arg2, String arg3, Type arg4) {
        log.info(String.format("methodThree with (Integer, Integer, String, Type) is invoked with (%s, %s, %s, %s)",
                arg1,
                arg2,
                arg3,
                arg4)
        );
        return 3;
    }
}
