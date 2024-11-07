package data;

public enum AnimalData {
    CAT,
    DOG,
    DUCK;

    public static AnimalData fromString(String command) {
        try {

            return AnimalData.valueOf(command.trim().toUpperCase());
        } catch (IllegalArgumentException e)
        {
            return null;}
    }
}









