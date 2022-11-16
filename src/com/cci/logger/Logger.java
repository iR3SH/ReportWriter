package com.cci.logger;

import com.cci.reportWriter.reportWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Logger {
    public Logger()
    {

    }
    public void Log(Exception ex)
    {
        try {
            File file = new File("\\Logs\\log_" + LocalDate.now() + ".txt");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(ex.getMessage() + reportWriter.SautLigne + Arrays.toString(ex.getStackTrace()));
                fileWriter.close();
            }
            else
            {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(ex.getMessage() + reportWriter.SautLigne + Arrays.toString(ex.getStackTrace()));
                fileWriter.close();
            }
        }
        catch (IOException ioException)
        {
            System.out.println(ioException.getMessage());
            ioException.getStackTrace();

        }
    }
}
