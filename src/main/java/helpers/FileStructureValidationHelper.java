package helpers;

import exceptions.FileStructureValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.StripeFileMapperService;

import java.io.IOException;

public final class FileStructureValidationHelper {

    //private constructor to avoid instantiation
    private FileStructureValidationHelper(){};

    public static Logger logger = LoggerFactory.getLogger(StripeFileMapperService.class);

    public static void validateInputFileHeader(String lineToValidate) throws FileStructureValidationException, IOException {
        if(lineToValidate.substring(0,1).equals("00")){
            logger.info("File ID is correct");
            lineToValidate.matches(".*\\d.*");
        }else{
            throw new FileStructureValidationException("File header ID is different than 00");
        }

        if(lineToValidate.substring(2,8).equals("mkrzesi")){
            logger.info("secondParameter is mkrzesi");
        }else{
            throw new FileStructureValidationException("secondParameter is not mkrzesi");
        }

        if(lineToValidate.substring(9,16).matches("[0-9]+")){
            logger.info("thirdParameter is correct");
        }else{
            throw new FileStructureValidationException("thirdParameter is invalid");
        }

        if(lineToValidate.substring(17,21).contains("start")){
            logger.info("FourthParam is correct");
        }else{
            throw new FileStructureValidationException("FourthParam is invalid");
        }
    }

    public static void validateTransactions(String transactionToValidate){}

    public static void validateFileTail(String fileTailToValidate){}
}
