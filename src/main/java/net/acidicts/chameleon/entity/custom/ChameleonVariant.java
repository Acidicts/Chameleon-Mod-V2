package net.acidicts.chameleon.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum ChameleonVariant {
    DEFAULT(0),
    ORCHID(1),
    WATER(2);

    private static final ChameleonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ChameleonVariant::getId)).toArray(ChameleonVariant[]::new);
    private final int id;

    ChameleonVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ChameleonVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
