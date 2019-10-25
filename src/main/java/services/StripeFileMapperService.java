package services;

import exceptions.FileStructureValidationException;
import helpers.FileStructureValidationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class StripeFileMapperService {

    public final static String PATH_TO_FILES = "src/main/resources/";
    public static Logger logger = LoggerFactory.getLogger(StripeFileMapperService.class);
    public static BufferedReader bufferedReader;
    public static StringBuilder stringBuilder = new StringBuilder();

    //private constructor to avoid instantiation
    private StripeFileMapperService(){};

    public static void openFile(String inputFileName) throws IOException, FileStructureValidationException {
        Path path = Paths.get(PATH_TO_FILES + inputFileName);
        bufferedReader = Files.newBufferedReader(path);
        logger.info("File opened");
        String line = bufferedReader.readLine();
        if(line.startsWith("00")){
            FileStructureValidationHelper.validateInputFileHeader(line);
        }
    }

    public static void readFileToEventObject() {

    }

    public static void createJsonWithObjData() {

    }

}
