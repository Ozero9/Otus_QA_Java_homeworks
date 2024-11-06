package animals.data;

public enum AnimalData {
    CAT,
    DOG,
    DUCK;

    public static AnimalData fromString(String command) {
        return AnimalData.valueOf(command.trim().toUpperCase());
    }
    }









