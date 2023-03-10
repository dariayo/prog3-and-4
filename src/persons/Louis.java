package persons;

import enums.*;
import exceptions.*;
import interfaces.*;

public class Louis extends Person implements ToArrive, Sayable {
    public Louis() {
        super("Луис", 45, 30, Gender.MAN, Status.CALM);
        System.out.println("Персонаж " + name + " теперь существует");
    }

    @Override
    public String sayAbout(String personName) {
        if (personName.equals("Патологоанатом")) {
            return "У вас наш студент, Виктор Паскоу";
        } else if (personName.equals("Патологоанатом") && this.status == Status.SHOCKED) {
            return "Что?";
        } else {
            return "Даже не знаю, что и сказать";
        }
    }

    public void toThink(Item item, Pascoe pascoe) {
        if (item == Item.CASE) {
            pascoe.age = (int) (pascoe.age + Math.random() * 50);
            pascoe.setLocation(Places.LUDLOW);
            this.status.setStatus(Status.SEARCH);

            Animal.CAT.getLocation(Places.CEMETRY);
            Animal.DOG.getLocation(Places.CEMETRY);

            if (pascoe.health == 0) {
                pascoe.toDie();
                pascoe.name = "Dead " + pascoe.getName();
            }
        } else if (item == null) {
            System.out.println("Я ни о чем не думаю");
        }
    }

    @Override
    public void arrive(Places places) throws IllegalLocationException {
        this.places = getLocation(places);
        if (places==Places.BUCKET || places==Places.TABLE){
            throw new IllegalLocationException(" невозможная локация для человека");
        }
        System.out.println(name + " прибыл в " + this.places.getDescription());
    }

    public String eat(Item food) {
        if (health < 50) {
            health = health + 10;
            return name + " съел " + food.getTitle();
        }
        return "Я не голодный";
    }

    public void toThrew(Item item) {
        if (item.property == "можно утилизировать" && item.size <= item.BUCKET.size) {
            item.changeLocation(Places.BUCKET);
            System.out.println(name + " " + item.getTitle() + " выбросил в " + item.places.getDescription());
        } else {
            System.out.println(" ничего не сделал ");
        }
    }

    public void toDrum(Item item) {
        if (item.property.equals("имеет аккустику")) {
            System.out.println(name + " побарабанил по " + item.getTitle());
        }
    }
}
