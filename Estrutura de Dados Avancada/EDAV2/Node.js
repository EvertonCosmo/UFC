const { Heap } = require("./Heap");

class Node {
  constructor(weight, value) {
    this.weight = weight;
    this.value = value;
    this.left = Heap;
    this.right = Heap;
  }
  getWeight() {
    return this.weight;
  }
}

module.exports = Node;
