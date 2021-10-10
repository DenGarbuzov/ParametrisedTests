package dgg;

public enum Panel {
    ARTICLES("Статьи"),
    NEWS("Новости"),
    HUBS("Хабы"),
    AUTHORS("Авторы"),
    COMPANIES("Компании");


    private String desc;

    Panel(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}