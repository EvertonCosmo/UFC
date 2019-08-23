all:run 

main.o:main.c
	gcc -c main.c 
lista.o:lista.c
	gcc -c lista.c
main.x:main.o lista.o
	gcc -o main.x main.o lista.o

run:main.x
	./main.x
clean: 
	rm -f *.x *.o
