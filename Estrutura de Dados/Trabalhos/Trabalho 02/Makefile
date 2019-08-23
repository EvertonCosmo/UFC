all:ord.x

ordenacaoVetor.o: ordenacaoVetor.c
	gcc -c ordenacaoVetor.c

main.o: main.c
	gcc -c main.c

bench.o: bench.c
	gcc -c bench.c

ord.x: ordenacaoVetor.o main.o bench.o
	gcc -o ord.x main.o ordenacaoVetor.o bench.o

clean:
	rm -f *.o *.x 