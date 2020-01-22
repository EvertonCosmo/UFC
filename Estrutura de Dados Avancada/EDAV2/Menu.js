const readLineSync = require("readline-sync");
const { Heap, union, insert, show_heap } = require("./Heap");
const Node = require("./Node");
let heap = new Heap(null);

let userOption;

const init = () => {
  process.stdout.write("\033c");
  console.log(heap);
  while (userOption != 0) {
    console.log(
      "\n1 => INDEXAR NOVO ELEMENTO AO CONJUNTO \n" +
        "2 => RESGATAR ELEMENTOS RELEVANTES \n" +
        "3 => EXIBIR CONJUNTO DE DADOS \n" +
        "4 => EXIBIR ELEMENTOS JÁ RESGATADOS \n" +
        "0 => SAIR\n"
    );
    userOption = readLineSync.question(">>");
    switch (userOption) {
      case "1":
        heap = insert(
          readLineSync.question("informe o valor do objeto :"),
          readLineSync.question("informe o peso do objeto : "),
          heap
        );
        show_heap(heap);
        break;
      case "2":
        removeElement();
        break;
      case "3":
        removeHeap();
        break;
      case "4":
        showAll();
        break;
      case "0":
        process.exit();
        break;
      default:
        init();
    }
  }
};

module.exports = init;
