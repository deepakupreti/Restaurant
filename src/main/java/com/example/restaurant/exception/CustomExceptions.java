package com.example.restaurant.exception;


public class CustomExceptions {

    private static final long serialVersionUID = -1451545022162714730L;

    public static class MaximumOrderLimitBreachedException extends RuntimeException {

        public MaximumOrderLimitBreachedException(String exception) {
            super(exception);
        }
    }

    public static class RestaurantClosedException extends RuntimeException {

        public RestaurantClosedException(String exception) {
            super(exception);
        }
    }
}
