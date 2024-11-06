public enum Pets {
    CAT,
    DOG,
    DUCK;

    public static Pets fromString(String command) {
        return Pets.valueOf(command.trim().toUpperCase());
    }
    }









