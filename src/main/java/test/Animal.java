package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class Animal implements Consumer<Cat> {
    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    @Override
    @Autowired
    public void accept(Cat cat) {
        this.cat = cat;
    }
}
