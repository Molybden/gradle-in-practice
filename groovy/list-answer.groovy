def first99 = (1..99)
def even = first99.collect{it*2}
def odd = first99-even
def oddBetween20And30 = odd.findAll{it>20 && it<30}
assert oddBetween20And30 == [21, 23, 25, 27, 29]