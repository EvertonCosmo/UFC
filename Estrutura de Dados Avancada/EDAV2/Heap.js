const Node = require("./Node");

class Heap {
  constructor(node) {
    this.element = node;
  }
}

const union = (heap1, heap2) => {
  if (heap1.element == undefined) {
    console.log("retornando heap2");
    console.log(heap2);
    return heap2;
  }
  if (heap2.element == undefined) {
    return heap2;
  }

  console.log(`heap2:`);
  console.log(heap2);
  if (heap1.element.value > heap2.element.value) {
    console.log(true);
    return union_heaps(heap1, heap2);
  } else {
    console.log(false);
    return union_heaps(heap2, heap1);
  }
};
const swap_son = heap => {
  var temp = new Heap(heap.element.left);
  heap.element.left = heap.element.right;
  heap.element.right = temp;
};

const union_heaps = (heap1, heap2) => {
  if (heap1.element.left == undefined) {
    heap1.element.left = heap2;
  } else {
    heap1.element.right = new Heap(heap1.element.right);
    console.log("heap direita");
    console.log(heap1.element.right);
    heap1.element.right = union(heap1.element.right, heap2);
    if (heap1.element.left.density < heap1.element.right.density) {
      swap_son(heap1);
    }
    heap1.element.density = heap1.element.right.element.density + 1;
  }
  return heap1;
};
// insert element
const insert = (value, weight, heapToUnion) => {
  var node_new = new Node(weight, value);
  var heap_new = new Heap(node_new);
  heapToUnion = union(heapToUnion, heap_new);

  return heapToUnion;
};
const show_heap = heap => {
  process.stdout.write("< ");
  if (heap != null) {
    process.stdout.write(`valor:${heap.element.value} `);
    process.stdout.write(`peso:${heap.element.weight} `);
    show_heap(heap.element.left);
    show_heap(heap.element.right);
  }
  process.stdout.write("> ");
};
module.exports = {
  Heap,
  union,
  insert,
  show_heap
};
