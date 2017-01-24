import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

abstract class Animal{
	
	private int order;
	String name;
	
	Animal(String s){
		this.name=s;
	}
	
	public int getOrder(){
		return this.order;
	}
	
	void setOrder(int order){
		this.order = order;
	}
	
	boolean isOlderThan(Animal animal){
		return this.order<animal.getOrder();
	}
	
}

class Cat extends Animal{
	Cat(String s){
		super(s);
	}
}

class Dog extends Animal{
	Dog(String s){
		super(s);
	}
}

class AnimalQueue{
	
	LinkedList<Cat> cats;
	LinkedList<Dog> dogs;
	int order=0; 
	
	AnimalQueue(){
		cats=new LinkedList<Cat>();
		dogs = new LinkedList<Dog>();
		
		
		Collections.sort(cats,new Comparator<Cat>(){
			@Override
			public int compare(Cat cat1,Cat cat2){
				if(cat1.getOrder() > cat2.getOrder())
					return 1;
				else if(cat1.getOrder() == cat2.getOrder()){
					return 0;
				} else {
					return -1;
				}
			}
		});
	}
	
	void enqueue(Animal animal){
		
		animal.setOrder(order);
		order++;
		
		if(animal instanceof Dog){
			dogs.add((Dog)animal);
		}
		
		if(animal instanceof Cat){
			cats.add((Cat) animal);
		}
		
	}
	
	
	public Cat dequeueCats(){
		
		return cats.remove();
		
	}
	
	public Dog dequeueDogs(){
		return dogs.remove();
	}
	public Animal dequeueAny(){
		if(dogs.isEmpty()){
			return dequeueCats();
		}
		
		if(cats.isEmpty()){
			return dequeueDogs();
		}
		
		if(dogs.peek().isOlderThan(cats.peek())){
			return dequeueDogs();
		} else  {
			return dequeueCats();
		}
	}
}

public class Solution {
	
	static int  findFib(int n){
		if(n==0 || n==1)
			return 1;
		int a= 0;
		int b=1;
		int fib=0;
		for(int i=2;i<=n;i++){
			fib = a+b;
			a=b;
			b=fib;
		}
		return fib;
	}
	
	public static void main(String args[]){
	
	AnimalQueue aq= new AnimalQueue();
	Dog dog1 = new Dog("hacker");
	Dog dog2 = new Dog("duffy");
	
	Cat cat1= new Cat("Katy");
	Cat cat2= new Cat("Kitty");

		aq.enqueue(dog1);
		aq.enqueue(dog2);
		aq.enqueue(cat1);
		aq.enqueue(cat2);
		
		System.out.println(aq.dequeueAny().name);
	
		System.out.println(aq.dequeueCats().name);
		System.out.println(aq.dequeueDogs().name);
		
		System.out.println(findFib(2) + " "+findFib(4));
	
	}
	
	
	

}


