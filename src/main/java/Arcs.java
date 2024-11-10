import processing.core.PApplet;

import static parameters.Parameters.*;
import static save.SaveUtil.saveSketch;

public class Arcs extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Arcs.class);
    }

    @Override
    public void settings() {
        size(1000, 1000);
        randomSeed(SEED);
        noiseSeed(floor(random(MAX_INT)));
    }

    @Override
    public void setup() {
        background(255);
        stroke(STROKE_COLOR.red(), STROKE_COLOR.green(), STROKE_COLOR.blue(), STROKE_COLOR.alpha());
        noFill();
        blendMode(MULTIPLY);
        noLoop();
    }

    @Override
    public void draw() {

        for (float r = MINIMUM_RADIUS; r < MAXIMUM_RADIUS; r += RADIUS_INCREASE) {
            float startAngle = START_ANGLE_MULTIPLIER * TWO_PI * sq(noise(r * NOISE_SCALE_FACTOR));
            float endAngle = startAngle
                    + END_ANGLE_MULTIPLIER * TWO_PI * floor(random(END_ANGLE_LOW_RANGE, END_ANGLE_HIGH_RANGE));
            arc(width / 2.f, height / 2.f, r, r, startAngle, endAngle);
        }

        saveSketch(this);
    }
}
