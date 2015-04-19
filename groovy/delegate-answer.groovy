class Favorite{
    String drinks = ''
    String foods = ''
    def methodMissing(String name, arg) {
        switch (name){
        case 'eat': 
            foods += foods?" and ":""
            foods += "${arg[0]}"
            break
        case 'drink': 
            drinks += drinks?" and ":""
            drinks += "${arg[0]}"
            break
        }
    }
    def propertyMissing(name, value){
        "$name".toString()
    }
    String toString(){
        "I like to drink $drinks. I like to eat $foods"
    }
}
def fav=new Favorite()
def preferences={
    drink wine
    drink coffee
    eat sushi
    eat scones
}
preferences.delegate=fav
preferences()
assert fav.toString()=='I like to drink wine and coffee. I like to eat sushi and scones'
