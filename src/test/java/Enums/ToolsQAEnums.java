package Enums;

public enum ToolsQAEnums {
    ITEMS("Book Store");
    private String name;

    private ToolsQAEnums(String name) {
        this.name = name;

    }

    public String getResourcesName() {
        return name;
    }
}
