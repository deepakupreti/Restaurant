package com.example.restaurant.constants;

public enum AppStatusCode {
    RESTAURANT_CLOSED("ERR001", "restaurant is closed"),
    RESTAURANT_ORDER_LIMIT_EXHAUSTED("ERR002", "restaurant order limit cant be exceeded");

    private String code;
    private String desc;
    private String text;

    AppStatusCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.text = code;
    }

    /**
     * Gets the app status code
     *
     * @return the status code number
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the app status code as a text string
     *
     * @return the status code as a text string
     */
    public String asText() {
        return text;
    }

    /**
     * Get the description
     *
     * @return the description of the status code
     */
    public String getDesc() {
        return desc;
    }
}
