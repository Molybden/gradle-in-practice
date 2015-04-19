def folder = new File('cleanup')
def odd = ['1','3','5','7','9']
def pattern = ~/Some text with the number \d./
folder.eachFile{file->
    if (odd.contains(file.name-'.txt')) println file  
    else{
        file.eachLine{
            if (!it.matches(pattern)) println file
        }
    }
}