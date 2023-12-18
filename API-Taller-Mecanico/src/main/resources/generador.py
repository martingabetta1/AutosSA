import random
from datetime import datetime, timedelta

def generate_inserts(num_inserts):
    inserts = []
    for i in range(num_inserts):
        fecha_inicio = datetime(2023, 11, 1) + timedelta(days=random.randint(0, 365))
        fecha_fin = fecha_inicio + timedelta(days=random.randint(1, 15))
        
        insert = f"INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES ({i}, '{fecha_inicio.strftime('%Y-%m-%d')}', '{fecha_fin.strftime('%Y-%m-%d')}', {random.randint(0, 12)}, {random.randint(0, 8)}, {random.randint(0, 4)}, 'Comentario {i}', 0, {random.randint(0, 10)}, false);"
        inserts.append(insert)

    return inserts

num_inserts = 100
inserts = generate_inserts(num_inserts)

file_path = 'inserts.sql'  # Nombre del archivo donde se guardarán los inserts

with open(file_path, 'w') as file:
    for insert in inserts:
        file.write(insert + '\n')

print(f"Se han guardado los inserts en {file_path}")
