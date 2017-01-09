### Big O notation

* O(1) Constant
* O(log n) Logarithmic
* O(n) Liniar
* O(n log n) Linearithmic
* O(n2) Quadratic


### Linked List

```java
Node insertTail(Node head,int data) {

  Node node = new Node();
  node.data = data;
  node.next = null;

  if (head == null) {
    head = node;
    return head;
  }

  Node tail = head;
  while (tail.next != null) {
    tail = tail.next;
  }
  tail.next = node;
  return head;
}
```

```java
Node insertHead(Node head,int x) {

  Node temp = new Node();
  temp.data = x;
  if (head == null) {
    temp.next = null;
  } else {
    temp.next = head;
  }
  return temp;
}
```

```java
Node innsertNth(Node head, int data, int position) {
  Node node = new Node();
  node.data = data;
  if (head == null || position == 0) {
    node.next = head;
    return node;
  }

  int i = 0;
  Node current = head;
  while (current != null) {
    if (i == position -1) {
      node.next = current.next;
      current.next = node;
      break;
    }
    current = current.next;
    i++;
  }
  return head;
}
```

```java
Node delete(Node head, int position) {

  if (position == 0) { return head.next; }

  int i = 0;
  Node temp = head;
  while (temp != null) {
    if (i == position -1) {
      Node next = temp.next;
      if (next != null) {
        temp.next = next.next;
        break;
      }
    }

    i++;
    temp = temp.next;
  }
  return head;
}
```

```java
void reverseAndPrint(Node head) {

  Node currNode = head;
  Node nextNode = null;
  Node prevNode = null;
  while(currNode!=null){
    nextNode = currNode.next;
    currNode.next = prevNode;
    prevNode = currNode;
    currNode = nextNode;
  }
  head = prevNode;

  currNode = head;
  while(currNode!=null) {
    System.out.println(currNode.data);
    currNode=currNode.next;
  }
}
```

```java
int compareLists(Node headA, Node headB) {

  while (headA != null && headB != null) {

    if (headA.data != headB.data) { return 0; }
    headA = headA.next;
    headB = headB.next;
  }

  if (headA == null && headB == null) {
    return 1;
  } else{
    return 0;
  }
}
```

```java
Node mergeLists(Node a, Node b) {
  if (a == null) {
    return b;
  } else if (b == null) {
    return a;
  }

  if (a.data < b.data) {
    a.next = MergeLists(a.next, b);
    return a;
  } else {
    b.next = MergeLists(a, b.next);
    return b;
  }
}
```

```java
int getNodeValueBehind(Node head,int n) {

  Node currNode = head;
  Node prevNode = null;
  Node nextNode = null;

  // Reversing
  while (currNode != null) {
    nextNode = currNode.next;
    currNode.next = prevNode;
    prevNode = currNode;
    currNode = nextNode;
  }   
  head = prevNode;

  int i = 0;

  // Counting
  while (head != null) {
    if (i  == n) { return head.data; }
    i++;
    head = head.next;
  }
  return 0;
}
```

```java
int getNodeValue(Node head, int n) {
  Node pointer = head;        
  int pointerPosition = 0;

  while (head.next != null){
    head = head.next;
    if (pointerPosition < n){
      pointerPosition++;
    } else {
      pointer = pointer.next;
    }
  }

  return pointer.data;
}
```

```java
Node removeDuplicates(Node head) {
  if (head == null) return head;

  Node lastNode = head;
  int lastValue = Integer.MIN_VALUE;
  Node current = head;
  while (current != null) {
    if (lastValue == current.data) {
      lastNode.next = current.next;
      current = lastNode.next;
    } else {
      lastValue = current.data;
      lastNode = current;
      current = current.next;
    }
  }  
  return head;
}
```

```java
Node removeDuplicatesRecursive(Node head) {
  if ( head == null ) return null;
  Node nextItem = head.next;
  while ( nextItem != null && head.data == nextItem.data ) {
    nextItem = nextItem.next;
  }
  head.next = RemoveDuplicates( nextItem );
  return head;
}
```

```java
boolean hasCycle(Node head) {
  if (head == null) return false;

  HashMap<Node, Integer> map = new HashMap<Node, Integer>();
  Node currentA = head;
  while (currentA != null) {
    if (map.containsKey(currentA)) {
      return true;
    } else {
      map.put(currentA,1);
    }
    currentA = currentA.next;
  }  
  return false;
}
```

```java
int hasCycleWithoutStorage(Node head) {
  if (head == null) return 0;

  Node slow = head;
  Node fast = head;
  while (fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast){
      return 1;
    }
  }
  return 0;
}

```

```java
int findMergeNode(Node headA, Node headB) {
  HashMap<Node,Integer> map = new HashMap<Node,Integer>();
  Node currentA = headA;
  while (currentA != null) {
    map.put(currentA,1);
    currentA = currentA.next;
  }

  Node currentB = headB;
  while(currentB != null) {
    if (map.containsKey(currentB)) {
      return currentB.data;
    } else {
      currentB = currentB.next;
    }
  }
  return currentB.data;
}
```

```java
int findMergeNodeWithoutStorage(Node headA, Node headB) {
  Node currentA = headA;
  Node currentB = headB;

  while (currentA != currentB) {
    if (currentA.next == null) currentA = headB;
    else currentA = currentA.next;
    if (currentB.next == null) currentB = headA;
    else currentB = currentB.next;
  }
  return currentB.data;
}
```

```java
Node sortedDoubleLinkedListInsert(Node head,int data) {
  Node current = head;
  if (current == null) {
    Node node = new Node();
    node.data = data;
    return node;
  }

  while (current != null) {
    if (data < current.data) {
      // Insert Before
      Node node = new Node();
      node.data = data;
      Node previous = current.prev;
      if (previous != null) { previous.next = node; }
      current.prev = node;
      node.next = current;
      node.prev = previous;
      break;

    } else {
      if (current.next == null) {
        // Insert After
        Node node = new Node();
        node.data = data;
        node.prev = current;
        current.next = node;
        return head;
      } else {
        current = current.next;
      }
    }
  }

  return head;
}
```

```java
Node sortedDoubleLinkedListInsertRecursive(Node head,int data) {
  Node n = new Node();
  n.data = data;
  if (head == null) {
    return n;
  } else if (data <= head.data) {
    n.next = head;
    head.prev = n;
    return n;
  } else {
    Node rest = sortedDoubleLinkedListInsert(head.next, data);
    head.next = rest;
    rest.prev = head;
    return head;
  }
}
```

```java
Node reverse(Node head) {
  if (head == null) return head;

  Node current = head;
  Node prev = null;
  while (current != null) {
    Node next = current.next;
    current.next = prev;
    current.prev = next;
    prev = current;
    current = next;
  }

  return prev;
}
```

### Trees

```java
void preOrderTraversal(Node root) {
  if (root == null) return;

  Node current = root;
  System.out.print(root.data + " ");
  preOrderTraversal(current.left);
  preOrderTraversal(current.right);  
}
```

```java
void postOrderTraversal(Node root) {
  if (root == null) return;

  postOrderTraversal(root.left);
  postOrderTraversal(root.right);
  System.out.print(root.data + " ");
}
```

```java
void inOrderTraversal(Node root) {
  if (root == null) return;

  inOrder(root.left);
  System.out.print(root.data + " ");
  inOrder(root.right);
}
```

```java
int getHeight(Node root) {
  if (root == null) return -1;
  return Math.max(getHeight(root.left),getHeight(root.right))+1;
}
```

```java
void topView(Node root) {
  leftBranch(root.left);
  System.out.print(root.data + " ");
  rightBranch(root.right);
}

void leftBranch(Node root) {
  if (root == null) {return;}
  leftBranch(root.left);
  System.out.print(root.data + " ");
}

void rightBranch(Node root)  {
  if (root == null) {return;}
  System.out.print(root.data + " ");
  rightBranch(root.right);
}
```

```java
void levelOrder(Node root) {
  LinkedList<Node> list = new LinkedList<Node>();

  if (root != null) list.add(root);
  while (list.peekFirst() != null ) {

    Node current = list.removeFirst ();
    System.out.print(current.data + " ");

    if (current.left != null)
    list.add(current.left);
    if (current.right != null)
    list.add(current.right);    
  }
}
```

```java
Node insertRecursive(Node root,int value) {

  if (root==null) {
    Node node=new Node();
    node.data=value;
    node.left=null;
    node.right=null;
    root=node;
  }

  else if(root.data>value)
  root.left=Insert(root.left,value);
  else if(root.data<value)
  root.right=Insert(root.right,value);
  return root;
}
```

```java
void huffmanDecoding(String S, Node root) {
  String result = "";
  Node current = root;
  for (int i = 0; i < S.length(); i++) {
    char character = S.charAt(i);
    if (character == '1') current = current.right;
    else current = current.left;

    if (current.left == null && current.right == null) {
      result = result + current.data;
      current = root;
    }
  }
  System.out.print(result);
}
```

```java
Node lowestCommonAncestor(Node root,int v1,int v2) {
  // Smaller than both
  if (root.data < v1 && root.data < v2) {
    return lowestCommonAncestor(root.right,v1,v2);
  }
  // Bigger than both
  if (root.data > v1 && root.data > v2) {
    return lowestCommonAncestor(root.left,v1,v2);
  }
  // Else solution already found
  return root;
}
```

```java
boolean checkBST(Node root) {
  return left(root.left, root.data) &&
  right(root.right, root.data);
}
boolean left(Node root, int pdata) {
  if (root == null) return true;
  if (root.data >= pdata) return false;
  return left(root.left, root.data) &&
  left(root.left, pdata) &&
  left(root.right, pdata) &&
  right(root.right, root.data);
}
boolean right(Node root, int pdata) {
  if (root == null) return true;
  if (root.data <= pdata) return false;
  return right(root.right, root.data) &&
  right(root.right, pdata) &&
  right(root.left, pdata) &&
  left(root.left, root.data);
}
```

### Arrays

```java
public ArrayList<String> joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for (String w : words) sentence.append(w);
    return sentence.toString();
}
```

```java
public ArrayList<String> mergeStrings(String[] words, String[] more) {
  ArrayList<String> sentence = new ArrayList<String>();
  for (String w : words) sentence.add(w);
  for (String w : more) sentence.add(w);
  return sentence;
}
```

```java
public void sparseArrays(int n, int q, String[] strings, String[] queries) {
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  for (int i = 0; i < n; i++) {
    String string = strings[i];
    if (map.containsKey(string) == false) {
      map.put(string, 1);
    } else {
      int value = map.get(string);
      value += 1;
      map.put(string, value);
    }
  }

  for (int i = 0; i < q; i++) {
    String query = queries[i];
    if (map.containsKey(query)) {
      System.out.println(map.get(query));
    } else {
      System.out.println(0);
    }
  }  
}
```

```java
public void leftRotation(int[] input, int n, int d) {
  int[] result = new int[n];
  for (int i = 0; i < n; i++) {    
    int position = i + d;
    if (position > n - 1) {
      position -= n;
    }
    result[i] = input[position];
  }

  for (int i= 0; i < result.length; i++) {
    System.out.print(result[i] + " ");
  }
}
```

### Queues

```java
public  class myQueueWithTwoStacks<T> {
  Stack<T> inbox = new Stack<T>();
  Stack<T> outbox  = new Stack<T>();

  public void enqueue(T value) { // Push onto newest stack
    inbox.push(value);
  }

  public T peek() {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }
    T value = outbox.pop();
    outbox.push(value);
    outbox.push(value);
    return outbox.pop();
  }

  public T dequeue() {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }
    return outbox.pop();
  }
}
```

### Sorting

```java
void bubbleSort(int array[]) {
  int n = array.length;
  int k;
  for (int m = n; m >= 0; m--) {
    for (int i = 0; i < n - 1; i++) {
      k = i + 1;
      if (array[i] > array[k]) {
        swapNumbers(i, k, array);
      }
    }
  }
}

void swapNumbers(int i, int j, int[] array) {
  int temp;
  temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}
```

```java
public int[] selectionSort(int[] arr){

  for (int i = 0; i < arr.length - 1; i++) {
    int index = i;
    for (int j = i + 1; j < arr.length; j++)
    if (arr[j] < arr[index])
    index = j;

    int smallerNumber = arr[index];
    arr[index] = arr[i];
    arr[i] = smallerNumber;
  }
  return arr;
}
```

```java
public  int[] insertionSort(int[] input){
  int temp;
  for (int i = 1; i < input.length; i++) {
    for(int j = i ; j > 0 ; j--){
      if(input[j] < input[j-1]){
        temp = input[j];
        input[j] = input[j-1];
        input[j-1] = temp;
      }
    }
  }
  return input;
}
```

```java
public void quickSort(int[] inputArr) {

  if (inputArr == null || inputArr.length == 0) {
    return;
  }
  this.array = inputArr;
  length = inputArr.length;
  quickSort(0, length - 1);
}

private void quickSort(int lowerIndex, int higherIndex) {

  int i = lowerIndex;
  int j = higherIndex;
  // calculate pivot number, I am taking pivot as middle index number
  int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
  // Divide into two arrays
  while (i <= j) {
    /**
    * In each iteration, we will identify a number from left side which
    * is greater then the pivot value, and also we will identify a number
    * from right side which is less then the pivot value. Once the search
    * is done, then we exchange both numbers.
    */
    while (array[i] < pivot) {
      i++;
    }
    while (array[j] > pivot) {
      j--;
    }
    if (i <= j) {
      exchangeNumbers(i, j);
      //move index to next position on both sides
      i++;
      j--;
    }
  }
  // call quickSort() method recursively
  if (lowerIndex < j)
  quickSort(lowerIndex, j);
  if (i < higherIndex)
  quickSort(i, higherIndex);
}

private void exchangeNumbers(int i, int j) {
  int temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}

```


```java
public void sort(int inputArr[]) {
  this.array = inputArr;
  this.length = inputArr.length;
  this.tempMergArr = new int[length];
  mergeSort(0, length - 1);
}

private void mergeSort(int lowerIndex, int higherIndex) {

  if (lowerIndex < higherIndex) {
    int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
    // Below step sorts the left side of the array
    mergeSort(lowerIndex, middle);
    // Below step sorts the right side of the array
    mergeSort(middle + 1, higherIndex);
    // Now merge both sides
    mergeSort(lowerIndex, middle, higherIndex);
  }
}

private void mergeParts(int lowerIndex, int middle, int higherIndex) {

  for (int i = lowerIndex; i <= higherIndex; i++) {
    tempMergArr[i] = array[i];
  }
  int i = lowerIndex;
  int j = middle + 1;
  int k = lowerIndex;
  while (i <= middle && j <= higherIndex) {
    if (tempMergArr[i] <= tempMergArr[j]) {
      array[k] = tempMergArr[i];
      i++;
    } else {
      array[k] = tempMergArr[j];
      j++;
    }
    k++;
  }
  while (i <= middle) {
    array[k] = tempMergArr[i];
    k++;
    i++;
  }
}
```


```java

```
