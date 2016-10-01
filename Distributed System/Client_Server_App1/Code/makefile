all: server client
server: server.o
	g++ server.o -o server -lpthread
server.o: server.cc
	g++ -c server.cc -lpthread
client: client.o
	g++ client.o -o client
client.o: client.cc
	g++ -c client.cc
clean:
	rm client server *.o


