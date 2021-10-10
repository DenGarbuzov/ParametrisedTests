package dgg;

public enum Panel {
    EVENT("События пользователей"),
    ADVANTAGE("Преимущества"),
    REVIEW("Отзывы"),
    FEEDBACK("Обратная связь");

    private String desc;

    Panel(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}