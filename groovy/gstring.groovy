def huvudperson = 'Stina'
def pronomen = /hon/
def genus = $/flicka/$
def saga = """
Det var en g�ng en ${genus} som hette $huvudperson.
$huvudperson bodde i en liten stuga invid en sj�.

En dag h�rde $pronomen att n�gon ropade i panik:
-${huvudperson.toUpperCase()}! 
${pronomen.capitalize()} sl�ppte genast allt och...
"""
println saga