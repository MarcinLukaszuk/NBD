import riak

client = riak.RiakClient()
bucket = client.bucket('s22009')


doc = bucket.new('doc', data={
    'imie': 'Marcin',
    'nazwisko': 'L',
    'waga': 70,
})
doc.store()


print('pobieranie')
added = bucket.get('doc')

print('wyswietlanie')
print(added.data)

print('')
print('modyfikacja wyswietlanie')
added.data['wzrost']=178
added.store()
modified = bucket.get('doc')
print(modified.data)

print('')
print('usuwanie')
modified.delete()

print('pobranie')
deleted = bucket.get('doc')
print(deleted.data)
