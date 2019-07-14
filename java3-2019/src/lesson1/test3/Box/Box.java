package lesson1.test3.Box;

import lesson1.test3.Fruit.Fruit;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private ArrayList<F> fruitList;

    public double getWeight(){
        double boxWeight = 0;
        for (F f: fruitList){
            boxWeight += f.getFruitWeight();
        }
        return boxWeight;
    }

    public Box(){
        fruitList = new ArrayList<F>();
    }

    public boolean compare(Box<?> anotherBox){
        boolean res = false;
        if (this.getWeight() == anotherBox.getWeight()){
            res = true;
        }
        return  res;
    }

    public void addFruit(F fruit){
        fruitList.add(fruit);
    }

    public void shiftFruit(Box<F> anotherBox, int cntFruit){
        if (this.getWeight() < cntFruit){
            System.out.println("Недостаточно фруктов в коробке.");
        }
        else if(cntFruit < 0){
            System.out.println("Указано отрицательное число");
        }
        else{
            while(cntFruit != 0){
                anotherBox.addFruit(this.fruitList.get(this.fruitList.size() - 1));
                this.fruitList.remove(this.fruitList.size() - 1);
                cntFruit--;
            }
        }
    }

}
