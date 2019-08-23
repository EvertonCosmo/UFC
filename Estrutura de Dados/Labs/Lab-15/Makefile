all:run 

main.o:main.c
	gcc -c main.c 
lista.o:lista.c
	gcc -c lista.c
filaLista.o:filaLista.c
	gcc -c filaLista.c
pilhaLista.o:pilhaLista.c
	gcc -c pilhaLista.c
main.x:main.o lista.o filaLista.o pilhaLista.o
	gcc -o main.x main.o lista.o filaLista.o pilhaLista.o 

run:main.x
	./main.x
clean: 
	rm -f *.x *.o

