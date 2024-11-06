public enum Command {
    ADD,
    LIST,
    EXIT;

    public static Command fromString(String command) {
        return Command.valueOf(command.trim().toUpperCase());
    }
        }


