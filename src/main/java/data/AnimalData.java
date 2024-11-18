package data;

public enum AnimalData {
    DOG,
    DUCK,
    CAT;

    public static AnimalData fromString(String command) {
        try {

            return AnimalData.valueOf(command.trim().toUpperCase());
        } catch (IllegalArgumentException e)
        {
            return null;}
    }

}
