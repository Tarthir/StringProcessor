package commandData;

/**
 * Created by tyler on 9/14/2017.
 */

public class CommandData {

    private String typeOfCommand;
    private String strToChange;

    public CommandData() {
    }

    CommandData(String typeOfCommand, String strToChange) {
        this.typeOfCommand = typeOfCommand;
        this.strToChange = strToChange;
    }

    public String getTypeOfCommand() {
        return typeOfCommand;
    }

    public String getStrToChange() {
        return strToChange;
    }
}
