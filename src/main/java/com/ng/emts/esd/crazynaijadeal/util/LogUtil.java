package com.ng.emts.esd.crazynaijadeal.util;


import com.ng.emts.esd.crazynaijadeal.model.base.CompleteLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

public class LogUtil {
    public static CompleteLog getExceptionMessageWithGUID(Exception e){
        StringBuilder errorBuilder = new StringBuilder();

        //generate uuid
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        errorBuilder.append(id);
        errorBuilder.append("\n");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        e.printStackTrace(printStream);
        printStream.close();

        errorBuilder.append(outputStream.toString());
        CompleteLog log = new CompleteLog(id, errorBuilder.toString());

        return log;
    }
    public static String getGUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
