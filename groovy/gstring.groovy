def huvudperson = 'Stina'
def pronomen = /hon/
def genus = $/flicka/$
def saga = """
Det var en gång en ${genus} som hette $huvudperson.
$huvudperson bodde i en liten stuga invid en sjö.

En dag hörde $pronomen att någon ropade i panik:
-${huvudperson.toUpperCase()}! 
${pronomen.capitalize()} släppte genast allt och...
"""
println saga