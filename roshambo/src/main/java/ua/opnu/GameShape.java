package ua.opnu;

public class GameShape {

    @Override
    public String toString() {
        if (this instanceof Rock) {
            return "Камінь";
        } else if (this instanceof Paper) {
            return "Папір";
        } else if (this instanceof Scissors) {
            return "Ножиці";
        }
        return "Невідома фігура";
    }
}