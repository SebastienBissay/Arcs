package parameters;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Parameters {
    public static final long SEED = 11;
    public static final Color STROKE_COLOR = new Color(0, 25, 75, 25.5f);
    public static final float MINIMUM_RADIUS = 1;
    public static final float MAXIMUM_RADIUS = 900;
    public static final float RADIUS_INCREASE = 0.1f;
    public static final float NOISE_SCALE_FACTOR = 0.01f;
    public static final float START_ANGLE_MULTIPLIER = 2;
    public static final float END_ANGLE_MULTIPLIER = 1 / 16f;
    public static final float END_ANGLE_LOW_RANGE = 1;
    public static final float END_ANGLE_HIGH_RANGE = 13;

    /**
     * Helper method to extract the constants in order to save them to a json file
     *
     * @return a Map of the constants (name -> value)
     */
    public static Map<String, ?> toJsonMap() throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();

        Field[] declaredFields = Parameters.class.getDeclaredFields();
        for(Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(Parameters.class));
        }

        return Collections.singletonMap(Parameters.class.getSimpleName(), map);
    }

    public record Color (float red, float green, float blue, float alpha) {}
}
