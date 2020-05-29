package by.bsu.model.entity;

import by.bsu.model.Engine;

import java.util.StringJoiner;

public class Locomotive extends RailTransport {
    private int speed;
    private Engine engine;

    private Locomotive(){
        super();
    }

    public static BuilderSub newLocomotive() {
        return new Locomotive().new BuilderSub();
    }

    public class BuilderSub extends RailTransport.BuilderBase<BuilderSub> {

        public BuilderSub speed(int speed) {
            Locomotive.this.speed = speed;
            return this;
        }

        public BuilderSub engine(Engine engine) {
            Locomotive.this.engine = engine;
            return this;
        }

        @Override
        BuilderSub This() {
            return this;
        }

        @Override
        public Locomotive build() {
            return Locomotive.this;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Locomotive.class.getSimpleName() + "[", "]")
                .add("speed=" + speed)
                .add("engine=" + engine)
                .toString();
    }
}
