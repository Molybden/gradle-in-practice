def character = 'Stina'
def pronoun = /she/
def gender = $/girl/$
def story = """
Once upon a time, there was a ${gender} named $character.
$character lived in a small cottage by a lake.

One day $pronoun heard someone screaming in panic:
-${character.toUpperCase()}!
${pronoun.capitalize()} dropped everything and...
"""
println story