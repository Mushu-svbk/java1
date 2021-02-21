package ru.progwards.java1.lessons.abstractnum;

//6 Реализовать класс Pyramid, переопределяющий метод
//public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат,
// и высотой равной стороне квадрата по формуле Segment*Segment*Segment/3;


public class Pyramid extends Figure3D {
    public Pyramid(Number segment) {
        super(segment);
    }

    public Number volume(){
        this.segment = segment.mul(segment.mul(segment));
        return this.segment.div(segment.newNumber("3"));
    }
}
