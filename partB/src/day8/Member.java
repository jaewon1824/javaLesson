package day8;

public class Member {

    private int age;
    private String name;
    
  
    public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

 public Member(int age, String name){
        this.age=age;
        this.name=name;
    }


    boolean isAdopt(Animal animal) {  
		if(animal instanceof Puppy && this.age >=15)return true;
		else if(animal instanceof Cat && this.age >=20)return true;
		else if(animal instanceof Rabbit && this.age >=13)return true;
		else if(age>=20)return true;
        else 
		return false;
	}



    
}
