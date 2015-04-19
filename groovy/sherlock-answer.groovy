def text = new File('The Adventures of Sherlock Holmes.txt').text.replace('.',' ')
def junkChars=['\n','—','(',')',',']
junkChars.each{ text = text.replace(it,'')}
text.split(' ').collect{it.toLowerCase()}.findAll{!it.isEmpty()}.countBy{it}.sort{it.value}.findAll{it.value>10}.each{println it}
