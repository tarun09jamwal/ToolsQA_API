package Enums;

public enum ToolsQAEnums {
    ITEMS("Book Store"),
    BOOK("Git Pocket Guide"),
    AUTHOR("Richard E. Silverman");

    private String name;

    private ToolsQAEnums(String name) {
        this.name = name;

    }

    public String getResourcesName() {
        return name;
    }
}
