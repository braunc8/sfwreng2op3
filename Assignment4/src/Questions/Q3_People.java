/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
 *
 * Define a class "People", there are three parameters: "String name", "int age" and
 * "String gender", you can define them with keywords "public" and "private", so that
 * users can access "name" anywhere in class, but will have a compile-time error message
 * if they want to access "gender" and "age".
 *
 * Write a method getName() in class People, and call it in "main" to print member1 and
 * member2' names.
 *
 * Input: None
 * Output: all members' names.
 *
 */
//DOUBLE CHECK
package Questions;


public class Q3_People {
    static class People{
        public String name;//initializing my fields to be private/public
        private int age;
        private String gender;
        public People(String _name, int _age, String _gender){//assigning given parameters to their correct field
            name =_name;
            age = _age;
            gender = _gender;
        }
        public String getName(){
            return (name);
        }//when we call the getName method, it gives us the object's name
    }

    public static void main(String[] args) {
        // define two members with following information
        // name:"Jack", age:19, gender:"Male";
        // name:"Rose", age:18, gender:"Female"
        People member1 = new People("Jack", 19, "Male");//instantiating my people objects
        People member2 = new People("Rose", 18, "Female");
        System.out.println("Member 1's name: " + member1.getName());//calling the getname function to print each member's name :)
        System.out.println("Member 2's name: " + member2.getName());
        /* place your code here */
    }

}
