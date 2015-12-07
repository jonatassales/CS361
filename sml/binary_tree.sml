(* Binary tree *)

datatype 'a BinaryTree = btempty;

(* Check if the tree is emprty*)
fun isEmpty(btempty) = true
| isEmpty(_) = false;

(* Find root of a tree*)
fun root(btempty) = raise MyException
| root(bt(r,lchild,rchild)) = r;

(* Find a left child *)
fun leftchild(btempty) = raise MyException
| leftchild(bt(r,lchild,rchild)) = lchild;