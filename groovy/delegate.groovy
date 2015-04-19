class Favorite{
    String drinks = ''
    String foods = ''
    //Fill in here
    
    
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
