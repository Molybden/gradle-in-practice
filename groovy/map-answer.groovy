def days = ['monday':'m�ndag','tuesday':'tisdag','wednesday':'onsdag','thursday':'torsdag','friday':'fredag','saturday':'l�rdag','sunday':'s�ndag']
assert days['monday']=='m�ndag'
def weekend = days.findAll{k,v->k.startsWith('s')}
assert weekend.size() == 2
assert weekend.sunday=='s�ndag'
def weekDays = days - weekend
assert weekDays.size() == 5