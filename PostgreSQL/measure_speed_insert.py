import psycopg2
import time

#number of rows to add in each batch
n = 10000

#generate single insert query
single_query = """INSERT INTO sample (column1, column2)
				  VALUES (1, 'I am always number one');"""
#generate one big query
big_query = "INSERT INTO sample(column1, column2) VALUES "
for i in range(n):
	big_query += "(1, 'I am always number one'),"
big_query = big_query.strip(',') + ';' #Replace , with ;

#connect to database and create cursor
conn = psycopg2.connect(host="localhost", database = "myDB", user = "postgres", password = "postgres")
cur = conn.cursor()

#time the n individual queries
start_time = time.time()
for i in range(n):
	cur.execute(single_query)
conn.commit()
stop_time = time.time()
print(n, ' individual queries took ', str(stop_time-start_time))

#time the big query
start_time = time.time()
cur.execute(big_query)
conn.commit
stop_time = time.time()
print(n, ' queries took ', str(stop_time-start_time),)

#close the cursor and database connection
cur.close()
conn.close()