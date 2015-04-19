//1: imports
//2: public
class User{
    //3: optional typing
    def name
    def age
    //4: getters and setters
    def list = new ArrayList()
    //5: skip variable declaration in method
    def quote(quote){
        //6: System.out.println to println
        //7: parantheses 
        println name+" says: '"+quote+"'"
    }
    def likes(name){
        list.add name 
    }
    def likes(){
        //8: optional return 
        list
    }    
}
def user = new User()
//9: with
user.with{
  name="Albert"
  age=42
  likes "Hamburgers"
  likes "Pizza"
  quote "Hi, nice to meet you."
}
def list = user.likes()