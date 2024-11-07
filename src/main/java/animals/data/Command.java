package animals.data;

public enum Command {
    ADD,
    LIST,
    EXIT;

    public static Command fromString(String command) {
        try {
            return Command.valueOf(command.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Такой команды не существует");
            return null;
        }
    }
}



