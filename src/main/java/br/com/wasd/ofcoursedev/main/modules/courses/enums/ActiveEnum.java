package br.com.wasd.ofcoursedev.main.modules.courses.enums;

public enum ActiveEnum {

    ACTIVE("Ativo"),
    DEACTIVE("Desativo");

    private String description;

    ActiveEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
