def days = ['monday':'måndag','tuesday':'tisdag','wednesday':'onsdag','thursday':'torsdag','friday':'fredag','saturday':'lördag','sunday':'söndag']
assert days['monday']=='måndag'
def weekend = days.findAll{k,v->k.startsWith('s')}
assert weekend.size() == 2
assert weekend.sunday=='söndag'
def weekDays = days - weekend
assert weekDays.size() == 5