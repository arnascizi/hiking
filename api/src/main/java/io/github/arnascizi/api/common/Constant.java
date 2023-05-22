package io.github.arnascizi.api.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String TRIP = "/trip";
    public static final String ID = "/${id}";
    public static final String ITEMS = "/items";

    public static final String CALCULATE = "/calculate";
    public static final String SEASON = "/{season}";

    // Endpoints
    public static final String TRIP_ENDPOINT = API + VERSION + TRIP;
    public static final String ITEMS_ENDPOINT = API + VERSION + ITEMS;
}
